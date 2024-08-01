package sec.exam01;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/_temp/test1.db");

		byte[] buf = new byte[5];
		
		int data = is.read(buf, 2, 3);
		for(int i = 0; i< buf.length; i++) {
			System.out.println(buf[i]);
		}
		
//		while(true) {
//			int data = is.read(buf);
//			if(data == -1) break;
//			for(int i = 0; i<data; i++) {
//				System.out.println(buf[i]);
//			}
//			
//		}
		
		is.close();
	}

}
