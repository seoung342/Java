package home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account {
	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;
	
	public Account(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
}
