package exam02;

public interface Role {
	
	// 둘이 같은거,  전부 대문자로 쓸경우 public static final, 상수
	public static final int MAX = 10;
	int MIN = 0;
	
	public abstract void doIt();
}
