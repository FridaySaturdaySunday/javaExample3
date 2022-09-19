package test.thread1;

public class ThreadC implements Runnable {

	@Override // ctrl + space 자동완성기능 이용
	public void run() {
		
		for(int k = 1; k <= 30; k++) {
			System.out.println("C-"+k);
			
			try {
				Thread.sleep(100); // 100ms 쉬고 처리
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
