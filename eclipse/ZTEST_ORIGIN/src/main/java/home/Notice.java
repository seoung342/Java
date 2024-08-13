package home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Notice {
	
	private int num;
	private String writer;
	private String title;
	private String content;
	private String regtime;
	private int hits;
	
	public Notice() {}
}
