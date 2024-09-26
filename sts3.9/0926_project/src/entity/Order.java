package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
	private Long id;
	private Long member_id;
	private String city;
	private String street;
	private String zipcode;
	private String order_date;
}
