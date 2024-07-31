package java0731; // p.506

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class Ex02 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		String path = Ex02.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path, "utf-8");
		System.out.println(path);
		properties.load(new FileReader(path));
		String driver = properties.getProperty("driver");
		System.out.println("드라이버 : " + driver);
		

	}

}
