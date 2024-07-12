package project3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ex03 {

	public static void main(String[] args) {
		
		Member[] list = {
				new Member("강하나","911224","010-1234-5678"),
				new Member("김하나","891224","010-1234-9876"),
				new Member("이하나","901224","010-1234-8787")
		};
		
		try(FileOutputStream fos = new FileOutputStream("c:\\_dev\\eclipse\\Practice\\src\\project3\\members.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);
			oos.flush();
			oos.close();
			System.out.println("객체를 파일에 저장했습니다.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
