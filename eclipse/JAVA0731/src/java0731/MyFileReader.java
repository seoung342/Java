package java0731;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyFileReader {

	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("c:/_temp/text/file1.txt");
		char[] buf = new char[100];
		int readNum = reader.read(buf);
		if(readNum != -1) {
			for(int i = 0; i < buf.length; i++) {
				System.out.print(buf[i]);
			}
			System.out.println();
		}
		reader.close();
		
	}

}
