package test.synch2;

public class SynchChangeNumber extends Thread {
	
	// 필드
	private SharedData sdata;

	// 생성자
	public SynchChangeNumber(SharedData sdata) {
		this.sdata = sdata;
	}

	@Override
	public void run() {
		for (int k = 1; k <= 5; k++) {
			sdata.calcNumber();
			// 해당 스래드가 공유자원 사용이 끝난 상태라면
			if (this.getState() == Thread.State.TERMINATED) {
				// 다른 스래드한테 신호를 보냄
				this.notify(); // 일어나!!
			}
		}
	}
}
