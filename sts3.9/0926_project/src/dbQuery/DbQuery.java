package dbQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import entity.Item;
import entity.ItemDAO;
import entity.Member;

public class DbQuery {
    private ItemDAO itemDAO;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    public DbQuery(DataSource dataSource) {
    	this.dataSource = dataSource;
        this.itemDAO = new ItemDAO(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    // 아이템 관련
    public List<Item> findAllItem() {
        return itemDAO.findAllItem();
    }
    
    public int itemCount() {
        return itemDAO.itemCount();
    }
    
    public void addItem(String name, int price, int amount) {
    	String sql = "insert into item(name, price, stockquantity) values( ?, ?, ?);";
    	jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, amount);
            return ps;
        });
    }
		
	// 회원 관련
    public void addMember(String name, String city, String street, String zipcode) {
    	String sql = "insert into member(name, city, street, zipcode) values ( ?, ?, ?, ?);";
    	jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, city);
            ps.setString(3, street);
            ps.setString(4, zipcode);
            return ps;
        });
    }
    
	public List<Member> findAllMember() {
		String sql = "select * from member";
		return jdbcTemplate.query(sql, (rs, rn)->{
			Member member = new Member(
					rs.getLong("id"),
					rs.getString("name"),
					rs.getString("city"),
					rs.getString("street"),
					rs.getString("zipcode")
			);
			return member;
		});
	}
	
	public int itemMember() {
		String sql = "select count(*) from member";
	    try (Connection conn = dataSource.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        rs.next();
	        return rs.getInt(1);
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	// 멤버 이름, 날짜로 주문 정보 조회
	public List<Map<String, Object>> memberOrders(String memberName, String date) {
	    String sql = "SELECT m.name AS memberName, i.name AS itemName, i.price, oi.count, DATE_FORMAT(o.order_date, '%Y-%m-%d') as order_date, m.city, m.street, m.zipcode " +
	                 "FROM member m " +
	                 "JOIN orders o ON m.id = o.member_id " +
	                 "JOIN order_item oi ON o.id = oi.order_id " +
	                 "JOIN item i ON oi.item_id = i.id " +
	                 "WHERE m.name = ? and DATE_FORMAT(o.order_date, '%Y-%m-%d') = ?";
	    
	    return jdbcTemplate.query(sql, new Object[]{memberName, date}, (rs, rn) -> {
	        Map<String, Object> orderInfo = new HashMap<>();
	        orderInfo.put("memberName", rs.getString("memberName"));
	        orderInfo.put("itemName", rs.getString("itemName"));
	        orderInfo.put("price", rs.getInt("price"));
	        orderInfo.put("count", rs.getInt("count"));
	        orderInfo.put("orderPrice", rs.getInt("price")*rs.getInt("count"));
	        orderInfo.put("orderDate", rs.getString("order_date"));
	        orderInfo.put("city", rs.getString("city"));
	        orderInfo.put("street", rs.getString("street"));
	        orderInfo.put("zipcode", rs.getString("zipcode"));
	        return orderInfo;
	    });
	}
	
	// 회원 이름으로 모든 주문 정보 보기
	public List<Map<String, Object>> memberOrders(String memberName) {
	    String sql = "SELECT m.name AS memberName, i.name AS itemName, i.price, oi.count, o.order_date, m.city, m.street, m.zipcode " +
	                 "FROM member m " +
	                 "JOIN orders o ON m.id = o.member_id " +
	                 "JOIN order_item oi ON o.id = oi.order_id " +
	                 "JOIN item i ON oi.item_id = i.id " +
	                 "WHERE m.name = ?";
	    
	    return jdbcTemplate.query(sql, new Object[]{memberName}, (rs, rn) -> {
	        Map<String, Object> orderInfo = new HashMap<>();
	        orderInfo.put("memberName", rs.getString("memberName"));
	        orderInfo.put("itemName", rs.getString("itemName"));
	        orderInfo.put("price", rs.getInt("price"));
	        orderInfo.put("count", rs.getInt("count"));
	        orderInfo.put("orderPrice", rs.getInt("price")*rs.getInt("count"));
	        orderInfo.put("orderDate", rs.getDate("order_date"));
	        orderInfo.put("city", rs.getString("city"));
	        orderInfo.put("street", rs.getString("street"));
	        orderInfo.put("zipcode", rs.getString("zipcode"));
	        return orderInfo;
	    });
	}
	
	
	
	// 물건 주문
	public void orderItem(Long memberId, Long itemId, int count) {
		String sql1 = "select * from member where id = ?";
		Member member = jdbcTemplate.queryForObject(sql1, new Object[]{memberId}, (rs, rowNum) -> new Member(
			    rs.getLong("id"),
			    rs.getString("name"),
			    rs.getString("city"),
			    rs.getString("street"),
			    rs.getString("zipcode")
			));
		
		KeyHolder keyHolder1 = new GeneratedKeyHolder();
        String sql2 = "insert into orders(member_id, city, street, zipcode, order_date)\r\n"
        		+ "values (?, ?, ?, ?, now());";

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, member.getId());
            ps.setString(2, member.getCity());
            ps.setString(3, member.getStreet());
            ps.setString(4, member.getZipcode());
            return ps;
        }, keyHolder1);

        Long order_id = keyHolder1.getKey().longValue();

        String sql3 = "insert into order_item ( item_id, order_id, count) values ( ?, ?, ? );";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql3);
            ps.setLong(1, itemId);
            ps.setLong(2, order_id);
            ps.setInt(3, count);
            return ps;
        });
        
        
       
	}
}
