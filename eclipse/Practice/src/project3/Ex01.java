package project3;

public class Ex01 {

	public static void main(String[] args) {
		
		Member mb = null;
		Member[] list = {
				new Member("강하나","911224","010-1234-5678"),
				new Member("김하나","891224","010-1234-9876"),
				new Member("이하나","901224","010-1234-8787")
		};
		for (Member member : list) {
			System.out.println(member);
		}
		int find = -1;
		
		for(int i =0; i <list.length; i++) {
			if(list[i].name.equals("강하나")) {
				find = i;
				mb = list[i];
				break;
			}
		}
		System.out.println("아이디 : "+find);
		System.out.println(mb);
	}
}
