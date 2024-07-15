package project3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex02 {

	public static void main(String[] args) {
		Member[] list = null;
		try(FileInputStream fis = new FileInputStream("c:\\_dev\\eclipse\\Practice\\src\\project3\\members.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			list = (Member[]) ois.readObject();
			
			System.out.println("파일에서 객체를 가져왔습니다.");
			
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for( Member member : list) {
			System.out.println(member);
		}
	}

}