package exam;

public class Sam06Ex {

	public static void main(String[] args) {
		Sample01<Integer> age = new Sample01<>();
		Sample01<String> name = new Sample01<>();

		age.setT(18);
		name.setT("고길동");
		System.out.println(age.getT() + ", "+ name.getT());
		
	}

}
