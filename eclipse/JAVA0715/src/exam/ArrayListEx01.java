package exam;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx01 {

	public static void main(String[] args) {
		
		ArrayList<String> list;	// String list[]; 
		list = new ArrayList<String>(); // new String[10];
		
//		ArrayList<String> list2 = new ArrayList<String>();
//		ArrayList<String> list3 = new ArrayList<>();
//		List<String> list4 = new ArrayList<>();
		
		list.add("홍길동");
		list.add("고길동");
		list.add("둘리");

//		이터레이터(자바 디자인 패턴)
		Iterator<String> it = list.iterator();
		while ( it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		
//		for (String str : list){
//			System.out.println(str);
//		}
		
		
	}

}
