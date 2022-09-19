package test.thread1;

public class ThreadA extends Thread {

	@Override
	public void run() {
		
		// 다른 스래드 클래스와 동시 처리하고 싶은 내용을 코드로 작성함
		
		for(int k = 1; k <= 30; k++) {
			System.out.println("★");
			
			try {
				Thread.sleep(100); // 100ms 쉬고 처리
			} catch (InterruptedException e) {
				e.printStackTrace();
				// interrupt() 메소드가 호출되면 이곳으로 옴
				// 이곳에서 interrupt로 대기상태 -> 실행상태
			}
		}
	}
}
