package test.thread1;

public class TestThread {

	public static void main(String[] args) {

		// Thread 상속하는방법 사용시
		ThreadA t1 = new ThreadA(); 
		ThreadB t2 = new ThreadB();
		
		// Runnable 인터페이스 상속하는 방법 사용시
		Thread t3 = new Thread(new ThreadC());

		
		// start() 호출 -> 멀티스레드 동작O
		t1.start();
		t2.start();
		t3.start();
		
		// run() 호출 -> 멀티스레드 동작X
//		t1.run(); 
//		t2.run();
//		t3.run();
		
		System.out.println("끝");
		return;
	}

}
