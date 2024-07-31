package java0731;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyFileWriter {

	public static void main(String[] args) throws IOException {
		File dir = new File("c:/_temp/text");
		File file1 = new File("c:/_temp/text/file1.txt");
		if ( dir.exists() == false) {
			dir.mkdir();
		}
		if(file1.exists() == false) {
			file1.createNewFile();
		}
		
		Writer writer = new FileWriter("c:/_temp/text/file1.txt");
		String str = "ABC";
		writer.write(str);
		writer.flush();
		writer.close();
	}

}
