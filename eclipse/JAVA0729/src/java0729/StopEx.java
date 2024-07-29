package java0729;

public class StopEx {

	public static void main(String[] args) {
		PrintThread01 printThread01 = new PrintThread01();
		printThread01.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
