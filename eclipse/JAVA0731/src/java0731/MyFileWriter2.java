package java0731;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyFileWriter2 {

	public static void main(String[] args) throws IOException {
		// 디렉토리 만들기
		File dir = new File("c:/_temp/file");
		if ( dir.exists() == false) {
			dir.mkdir();
		}
		
		// 파일 만들어서 내용 저장
		Writer writer = new FileWriter("c:/_temp/file/data.txt");
		String str = "ABC";
		writer.write(str);
		writer.flush();
		writer.close();
	}

}
