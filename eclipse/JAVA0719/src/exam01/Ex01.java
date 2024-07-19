package exam01;

public class Ex01 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySql 드라이버 로딩 성공!");
		}catch(ClassNotFoundException e) {
			System.out.println("MySql 드라이버 로딩 실패!");
		}
	}
}
