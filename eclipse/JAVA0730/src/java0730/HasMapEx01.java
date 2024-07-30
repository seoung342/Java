package java0730;	// p.596

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HasMapEx01 {
	public static void main(String []args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		System.out.println("총 Entry 수 : "+map.size());
		
		System.out.println("\t홍길동 : "+map.get("홍길동"));
		System.out.println();
		
		// 둘이 같다
		Set<String> keySet = map.keySet();
//		Iterator<String> keyInterator = keySet.iterator();
//		while(keyInterator.hasNext()) {
//			String key = keyInterator.next();
//			Integer value = map.get(key);
//			System.out.println("\t"+key+":"+value);
//		}
		for(String str: keySet) {
			System.out.println(str);
			System.out.println(map.get(str));
		}
		System.out.println();
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for ( Map.Entry<String, Integer> kv : entrySet) {
			String k = kv.getKey();
			Integer v = kv.getValue();
			System.out.println(k +"," + v);
		}
		
	}
}
