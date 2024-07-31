package exam;

import java.util.HashMap;

public class Ex01 {

	public static void main(String[] args) {
		var map = new HashMap<String, Integer>();
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		
		var entrySet = map.entrySet();
		for( var mm : entrySet) {
			System.out.println(mm);
			
			var k1 = mm.getKey();
			var v1 = mm.getValue();
			
			System.out.println(k1 +", " + v1);
		}

	}

}
