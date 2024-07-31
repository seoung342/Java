package exam;

public class Ex05 {

	public static void main(String[] args) {
		String grade = null;
		switch(grade) {
			case "A", "a" ->{
			System.out.println("우수 회원");
			}
			case "B", "b" ->{
				System.out.println("일반 회원");
			}
			case null -> System.out.println("Null");
			default ->{
				System.out.println("손님");
			}
		}
	}

}
