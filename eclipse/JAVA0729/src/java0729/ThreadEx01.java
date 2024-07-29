package java0729;

public class ThreadEx01 {
	public static void main(String[] args) {
		Thread mThread = Thread.currentThread();
		System.out.println(mThread.getName());
		
		ThreadA threadA = new ThreadA();
		threadA.start();
		
		// 익명 자식 객체 생성 p.552
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 2; i++) {
					System.out.println(getName() + "가 출력한 내용");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		threadB.setName("ThreadB");
		threadB.start();
		
		// Runnable 구현 객체 생성 p.549
		Thread threadC = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 2; i ++) {
					System.out.println("ThreadC 가 출력한 내용");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		threadC.start();
	}
}
