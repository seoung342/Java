package exam01;

public class DishWasher extends HomeAppliancies{
	@Override
	public void turnOff() {
		System.out.println("끄기");
	}
	@Override
	public void turnOn() {
		System.out.println("켜기");
	}

}