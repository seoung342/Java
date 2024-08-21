package home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileStorage {
	private int num;
	private String fname;
	private String ftime;
	private int fsize;
	private String user_id;
	private String writer;
	private int hits;
	private String title;
	private String content;
	
	public FileStorage() {
		
	}
}
