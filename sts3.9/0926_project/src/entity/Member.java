package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Member {
	public Member(Long memberId) {
		this.id = memberId;
	}
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;
}
