package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DbConfig;
import config.DbQueryConfig;
import dbQuery.DbQuery;
import entity.Item;
import entity.Member;

public class MainUsingDbQuery {
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class,
				DbQueryConfig.class);
		DbQuery dbQuery = ctx.getBean(DbQuery.class);

		try {
			while (true) {
				System.out.println("==========================================================");
				System.out.print("명령어를 입력하세요 >> ");
				String command = reader.readLine();
				if (command.equalsIgnoreCase("exit")) {
					System.out.println("종료합니다.");
					break;
				}
				if (command.startsWith("add item")) {
					processAddItem(dbQuery,command.split(" "));
					continue;
				}else if (command.startsWith("add member")) {
					processAddMember(dbQuery,command.split(" "));
					continue;
				} else if (command.startsWith("find item")) {
					processFindAllItem(dbQuery);
					continue;
				} else if ( command.startsWith("find all member")) {
					processFindAllMember(dbQuery);
					continue;
				} else if ( command.startsWith("fmod ")) { 
					processMemberOrdersDate(dbQuery,command.split(" "));
					continue;
				}else if ( command.startsWith("fmoa ")) { 
					processMemberOrdersAll(dbQuery,command.split(" "));
					continue;
				} else if ( command.startsWith("orderItem ")) {
					processOrderItem(dbQuery, command.split(" "));
					continue;
				} else if ( command.startsWith("cancelOrder ")) {
					processCancelOrder(dbQuery, command.split(" "));
					continue;
				} else if ( command.startsWith("find all orders")) {
					processAllOrders(dbQuery, command.split(" "));
					continue;
				}else if ( command.startsWith("find all order item")) {
					processAllOrderItem(dbQuery, command.split(" "));
					continue;
				} else if ( command.startsWith("help")) {
					printHelp();
					continue;
				}
				printHelp();
			}
		} catch (IOException e) {
			System.err.println("입력 오류: " + e.getMessage());
		} finally {
			ctx.close();
		}
	}
	
	// 상품 추가
	private static void processAddItem(DbQuery dbQuery, String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
		
		String item_name = arg[2];
		String item_price = arg[3];
		String item_amount = arg[4];
		
		dbQuery.addItem(item_name, Integer.parseInt(item_price), Integer.parseInt(item_amount));
		
	}
	
	// 회원 추가
	private static void processAddMember(DbQuery dbQuery, String[] arg) {
		if(arg.length != 6) {
			printHelp();
			return;
		}
		
		String name = arg[2];
		String city = arg[3];
		String street = arg[4];
		String zipcode = arg[5];
		
		dbQuery.addMember(name, city, street, zipcode);
	}
	
	// 모든 상품 확인
	private static void processFindAllItem(DbQuery dbQuery) {
		List<Item> items = dbQuery.findAllItem();
		int count = dbQuery.countItem();
		System.out.println("총 아이템 수: " + count);
		for (Item item : items) {
			System.out.println(item);
		}
	}
	
	// 모든 회원 확인
	private static void processFindAllMember(DbQuery dbQuery) {
		List<Member> members = dbQuery.findAllMember();
		int count = dbQuery.countMember();
		System.out.println("총 회원 수: " + count);
		for (Member member : members) {
			System.out.println(member);
		}
	}
	
	// 주문 상품 날짜로 확인
	private static void processMemberOrdersDate(DbQuery dbQuery, String[] arg) {
		if(arg.length != 3) {
			printHelp();
			return;
		}		
		String memberName = arg[1];
		String date = arg[2];
	    List<Map<String, Object>> orders = dbQuery.memberOrders(memberName, date);
	    int total = 0;
	    if (orders.isEmpty()) {
	        System.out.println("주문이 없습니다.");
	    } else {
	        Map<String, Object> firstOrder = orders.get(0);
	        System.out.println("   회원 이름: " + memberName);
	        System.out.print("   배달 장소 : " + firstOrder.get("city") + " " + firstOrder.get("street") + " " + firstOrder.get("zipcode"));
	        System.out.println("   주문 날짜 : " + firstOrder.get("orderDate"));
	        for (Map<String, Object> order : orders) {
	        	System.out.print("    주문 번호 : " + order.get("orderId"));
	            System.out.print(", 제품 : " + order.get("itemName"));
	            System.out.print(", 가격: " + order.get("price"));
	            System.out.print(", 수량: " + order.get("count"));
	            System.out.println(", 주문 가격: " + order.get("orderPrice"));
	            total = total + Integer.parseInt(String.valueOf(order.get("orderPrice")));
	        }
	        System.out.println("                총 주문 금액 >> " + total);
	    }
	}
	
	// 회원의 모든 주문 정보
	private static void processMemberOrdersAll(DbQuery dbQuery, String[] arg) {
		if(arg.length != 2) {
			printHelp();
			return;
		}		
		String memberName = arg[1];
	    List<Map<String, Object>> orders = dbQuery.memberOrders(memberName);
	   
	    if (orders.isEmpty()) {
	        System.out.println("주문이 없습니다.");
	    } else {
	        Map<String, Object> firstOrder = orders.get(0);
	        System.out.print("   회원 이름: " + memberName);
	        System.out.println("   배달 장소 : " + firstOrder.get("city") + " " + firstOrder.get("street") + " " + firstOrder.get("zipcode"));
	        for (Map<String, Object> order : orders) {
	        	System.out.print("    주문 번호 : " + order.get("orderId"));
	            System.out.print(", 제품 : " + order.get("itemName"));
	            System.out.print(", 가격: " + order.get("price"));
	            System.out.print(", 수량: " + order.get("count"));
	            System.out.print(", 주문 가격: " + order.get("orderPrice"));
	            System.out.println(", 주문 날짜: " + order.get("orderDate"));
	        }
	    }
	}
	
	// 상품 주문
	private static void processOrderItem(DbQuery dbQuery, String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		String member_id = arg[1];
		String item_id = arg[2];
		String count = arg[3];
		dbQuery.orderItem(Long.parseLong(member_id), Long.parseLong(item_id), Integer.parseInt(count));
	}
	
	// 주문, 상품 취소
	private static void processCancelOrder(DbQuery dbQuery, String[] arg) {
		if(arg.length != 2) {
			printHelp();
			return;
		}
		String order_id = arg[1];
		dbQuery.cancelOrder(Long.parseLong(order_id));
	}
	
	// 모든 주문 정보
	private static void processAllOrders(DbQuery dbQuery, String[] arg) {
		if(arg.length != 3) {
			printHelp();
			return;
		}
		
		 List<Map<String, Object>> orders = dbQuery.allOrders();
		    for (Map<String, Object> order : orders) {
		        System.out.println(order);
		    }
	}
	
	// 모든 주문 상품 정보
	private static void processAllOrderItem(DbQuery dbQuery, String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		
		List<Map<String, Object>> orders = dbQuery.allOrderItem();;
	    for (Map<String, Object> order : orders) {
	        System.out.println(order);
	    }
	}
	
	// 도움말
	private static void printHelp() {
		System.out.println();
		System.out.println("--------명령어 사용법--------");
		System.out.println("help >> 명령어 사용법");
		System.out.println("exit >> 프로그램 종료");
		System.out.println("find item >> 모든 아이템 정보");
		System.out.println("find all member >> 모든 회원 정보");
		System.out.println("find all orders >> 모든 주문 정보");
		System.out.println("find all order item >> 모든 주문 상품 정보");
		System.out.println("add item name price amount >> 아이템 추가 ( 이름, 가격, 갯수 )");
		System.out.println("add member name city street zipcode >> 회원 추가 ( 이름, city, street, zipcode )");
		System.out.println("orderItem member_id item_id count >> 물건 주문 ( 회원_아이디 물건_번호 갯수 )");
		System.out.println("cancelOrder order_id >> 주문 취소 ( 주문_번호 )");
		System.out.println("fmoa member_name >> 회원 모든 주문 정보 확인 ( 이름 ) find member orders all");
		System.out.println("fmod member_name date >> 회원 주문 정보 확인 ( 이름 날짜 ) find member orders date");
		System.out.println();
	}
}