package sec.exam07;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadEx {

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("C:/_temp/board1.csv");
		String line = "";
	
		BufferedReader br = new BufferedReader(reader);
		while((line = br.readLine()) != null) {
			// csv 파일을 각 줄의 쉼표로 분리
			String[] data = line.split(",");
			BoardDTO dto = new BoardDTO(0,data[0],data[1],data[2],null,0);
			System.out.println(dto.toString());			
		}
		reader.close();
	}

}
