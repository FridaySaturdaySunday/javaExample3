package test.thread1;

public class ThreadB extends Thread {

	@Override
	public void run() {
		
		// 다른 스래드 클래스와 동시 처리하고 싶은 내용을 코드로 작성함
		
		for(int k = 1; k <= 30; k++) {
			System.out.println(k);
			
			try {
				Thread.sleep(100); // 100ms 쉬고 처리
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
