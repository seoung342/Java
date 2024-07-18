package exam01;

public class Washer extends HomeAppliancies{
	@Override
	public void turnOff() {
		System.out.println("Washer를 껐습니다.");
	}
	@Override
	public void turnOn() {
		System.out.println("Washer를 켰습니다.");
	}
}
