package exam;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx02 {

	public static void main(String[] args) {
		
		ArrayList<Object> list = new ArrayList<>();
		
		
		list.add("홍길동");
		list.add("고길동");
		list.add("둘리");
		list.add(123);

//		이터레이터(자바 디자인 패턴)
		Iterator<Object> it = list.iterator();
		while ( it.hasNext()) {
			Object str = it.next();
			System.out.println(str);
		}
		
//		for (String str : list){
//			System.out.println(str);
//		}
		
		
	}

}
