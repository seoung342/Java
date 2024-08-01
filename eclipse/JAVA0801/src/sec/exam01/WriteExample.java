package sec.exam01;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/_temp/test1.db");
		
		byte[] array = {10, 20, 30, 40};
		os.write(array, 1, 3);
		
//		byte a = 10;
//		byte b = 20;
//		byte c = 30;
//		
//		os.write(a);
//		os.write(b);
//		os.write(c);
		
		os.flush();
		os.close();
	}

}
