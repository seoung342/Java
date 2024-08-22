package home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Finance {
	private int num;
	private String country_type;
	private String ticker;
	private double amount;
	private double purchase_price;
	private double now_price;
	private double purchase_total;
	private double now_total;
	private String hiredate;
	private String user_id;
	
	public Finance() {
		
	}
}
