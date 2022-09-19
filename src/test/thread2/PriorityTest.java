package test.thread2;

public class PriorityTest extends Thread{
	
//	<스레드 우선 순위>
//	Thread 클래스가 가지고 있는 priority 멤버변수를 이용해 우선 순위를 지정한다.
//	스레드 우선 순위는 int형 정수값 1~10의 값을 가지며 기본값은 5이다.
//	스레드의 우선 순위는 setPriority() 메소드를 이용해 지정할 수 있고, getPriority() 메소드를 이용해 확인할 수 있다.
	
	// 필드
	private String threadName; // 스레드 이름 기억용
	
	// 생성자
	public PriorityTest(String threadName) {
		this.threadName = threadName;
	}
	
	// 메소드
	@Override
	public void run() {
		// 스레드 이름 출력 3번 반복
		for(int i=0; i<30; i++) {
			System.out.println(threadName + "가 구동됨.");
		}
	}
	
	
	public static void main(String[] args) {
		// 우선 순위 테스트용
		Thread t1 = new PriorityTest("제일 높은 스레드");
		Thread t2 = new PriorityTest("보통 스레드");
		Thread t3 = new PriorityTest("제일 낮은 스레드");
		
		t1.setPriority(Thread.MAX_PRIORITY); // 10
		t2.setPriority(Thread.NORM_PRIORITY); // 5
		t3.setPriority(Thread.MIN_PRIORITY); // 1
		
		t1.start();
		t2.start();
		t3.start();
		
	}


}
