package exam;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VextorEx01 {

	public static void main(String[] args) {
		
		List<String> list = new Vector<>();
		
		
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
