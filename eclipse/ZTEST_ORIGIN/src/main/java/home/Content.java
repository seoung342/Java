package home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Content {
	private int num;
	private String writer;
	private String title;
	private String content;
	private String regtime;
	private int hits;
	private String user_id;
	
	public Content(){}
}
