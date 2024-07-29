package java0729;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ex04 {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strNow = sdf.format(date);
		System.out.println(strNow);
		
		LocalDateTime now1 = LocalDateTime.now();
		String strNow1 = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(now1);
		System.out.println(strNow1);
	}
}
