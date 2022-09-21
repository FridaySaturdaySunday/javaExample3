package test.synch2;

public class SynchReadNumber extends Thread {
	
	// 필드
	private SharedData sdata;

	// 생성자
	public SynchReadNumber(SharedData sdata) {
		this.sdata = sdata;
	}

	@Override
	public void run() {
		for (int n = 1; n <= 10; n++) {
			try {
				// 다른 스래드의 동기화 사용이 끝나기를 기다리는 상태이면 (정지상태)
				if (this.getState() == Thread.State.BLOCKED) {
					// 다른 스래드가 신호를 보낼 때까지 기다려라.
					this.wait(); // 대기해!!
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			sdata.printNumber();
		}
	}

}
