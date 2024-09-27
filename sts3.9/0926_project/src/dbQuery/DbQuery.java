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
    
    // 모든 상품 찾기
    public List<Item> findAllItem() {
        return itemDAO.findAllItem();
    }
    
    // 상품 숫자
    public int countItem() {
        return itemDAO.countItem();
    }
    
    // 상품 추가
    public void addItem(String name, int price, int amount) {
    	String sql = "insert into item(name, price, stockquantity) values( ?, ?, ?);";
    	int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, amount);
            return ps;
        });
    	// 행이 추가되었으면 성공 메시지 출력
        if (rowsAffected > 0) {
            System.out.println("상품이 추가 됬습니다.");
        } else {
            System.out.println("상품 추가에 실패했습니다.");
        }
    }
		
	// 회원 추가
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
    
    // 모든 회원 찾기
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
	
	// 회원 숫자
	public int countMember() {
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
	    String sql = "SELECT m.name AS memberName, i.name AS itemName, i.price, oi.count, DATE_FORMAT(o.order_date, '%Y-%m-%d') as order_date, m.city, m.street, m.zipcode, oi.order_id as order_id " +
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
	        orderInfo.put("orderId", rs.getString("order_id"));
	        return orderInfo;
	    });
	}
	
	// 회원 이름으로 모든 주문 정보 보기
	public List<Map<String, Object>> memberOrders(String memberName) {
	    String sql = "SELECT m.name AS memberName, i.name AS itemName, i.price, oi.count, o.order_date, m.city, m.street, m.zipcode, oi.order_id " +
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
	        orderInfo.put("orderId", rs.getString("order_id"));
	        return orderInfo;
	    });
	}
	
	// 물건 주문
	public void orderItem(Long memberId, Long itemId, int count) {
	    // 회원 정보 구하기
		String sql1 = "select * from member where id = ?";
	    Member member = jdbcTemplate.queryForObject(sql1, new Object[]{memberId}, (rs, rowNum) -> new Member(
	            rs.getLong("id"),
	            rs.getString("name"),
	            rs.getString("city"),
	            rs.getString("street"),
	            rs.getString("zipcode")
	    ));
	    
	    // 물건 갯수 구하기
	    String sql2 = "select stockquantity from item where id = ?";
	    int item_count = jdbcTemplate.queryForObject(sql2, new Object[]{itemId}, Integer.class);

	    // 재고 수량 체크
	    if (item_count < count) {
	        System.out.println("주문하는 물건 갯수가 너무 많습니다.");
	        return; // 메서드를 종료하여 SQL 실행을 건너뜁니다.
	    }
	    
	    KeyHolder keyHolder1 = new GeneratedKeyHolder();
	    String sql3 = "insert into orders(member_id, city, street, zipcode, order_date) values (?, ?, ?, ?, now());";
	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
	        ps.setLong(1, member.getId());
	        ps.setString(2, member.getCity());
	        ps.setString(3, member.getStreet());
	        ps.setString(4, member.getZipcode());
	        return ps;
	    }, keyHolder1);
	    Long order_id = keyHolder1.getKey().longValue();

	    String sql4 = "insert into order_item (item_id, order_id, count) values (?, ?, ?);";
	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection.prepareStatement(sql4);
	        ps.setLong(1, itemId);
	        ps.setLong(2, order_id);
	        ps.setInt(3, count);
	        return ps;
	    });
	    
	    // 주문 후 물건 갯수 수정
	    int update_item_count = item_count - count;
	    String sql5 = "UPDATE item SET stockquantity = ? WHERE id = ?;";
	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection.prepareStatement(sql5);
	        ps.setInt(1, update_item_count);
	        ps.setLong(2, itemId);
	        return ps;
	    });
	}

	// 주문, 상품 취소 
	public void cancelOrder(Long orderId) {	    
		// 취소한 물건 상품 번호 구하기
		String sql1 = "select item_id from order_item where order_id = ?;";
		int cancel_item_id = jdbcTemplate.queryForObject(sql1, new Object[]{orderId}, Integer.class);
		
		// 취소한 물건 상품 갯수 구하기
		String sql2 = "select count from order_item where order_id = ?;";
		int cancel_item_count = jdbcTemplate.queryForObject(sql2, new Object[]{orderId}, Integer.class);

		// 현재 상품 갯수 구하기
		String sql3 = "select stockquantity from item where id = ?;";
		int now_item_count = jdbcTemplate.queryForObject(sql3, new Object[] {cancel_item_id}, Integer.class);
		
		// 물건 갯수 수정
		int total_item_count = cancel_item_count + now_item_count;
		String sql4 = "UPDATE item SET stockquantity = ? WHERE id = ?;";
		jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql4);
            ps.setInt(1, total_item_count);
            ps.setLong(2, cancel_item_id);
            return ps;
        });		
		
		// 주문 삭제
		String sql5 = "delete from orders where id = ?;";
		jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql5);
            ps.setLong(1, orderId);
            return ps;
        });
		
		// 주문 상품 취소
		String sql6 = "delete from order_item where order_id = ?;";
		jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql6);
            ps.setLong(1, orderId);
            return ps;
        });
		
		
		
	}

	// 모든 주문 정보
	public List<Map<String, Object>> allOrders() {
	    String sql = "SELECT * FROM orders;";
	    return jdbcTemplate.query(sql, (rs, rn) -> {
	        Map<String, Object> orderInfo = new HashMap<>();
	        orderInfo.put("id", rs.getString("id"));
	        orderInfo.put("member_id", rs.getString("member_id"));
	        orderInfo.put("city", rs.getString("city"));
	        orderInfo.put("street", rs.getString("street"));
	        orderInfo.put("zipcode", rs.getString("zipcode"));
	        return orderInfo;
	    });
	}
	
	// 모든 주문 상품 정보
	public List<Map<String, Object>> allOrderItem() {
	    String sql = "select * from order_item;";
	    return jdbcTemplate.query(sql, (rs, rn) -> {
	        Map<String, Object> orderInfo = new HashMap<>();
	        orderInfo.put("id", rs.getString("id"));
	        orderInfo.put("item_id", rs.getString("item_id"));
	        orderInfo.put("order_id", rs.getString("order_id"));
	        orderInfo.put("count", rs.getString("count"));
	        return orderInfo;
	    });
	}
}
