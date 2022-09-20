package test.synch2;

public class TestSynchronized {

	public static void main(String[] args) {

		// 공유영역 동기화 오류 해결 테스트
		SharedData shareObj = new SharedData();
		
		// Thread 상속하는 방법 사용시
		Thread changeThread = new SynchChangeNumber(shareObj);
		Thread readThread = new SynchReadNumber(shareObj);
		
		changeThread.start();
		readThread.start();

	}

}
