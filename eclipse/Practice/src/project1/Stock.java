package project1;

public class Stock implements java.io.Serializable{
	String ticker;
	double price;
	double amount;
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void getInfo() {
		System.out.println("Stock [ticker=" + ticker + ", price=" + price + ", amount=" + amount + "]");
	}
	
}
