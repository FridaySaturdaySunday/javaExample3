package test.synch2;

public class TestSynchronized {

	public static void main(String[] args) {

		// 공유영역 동기화 오류 해결 테스트
		SharedData shareObj = new SharedData();
		
		// Thread 상속하는 방법 사용
		Thread changeThread = new SynchChangeNumber(shareObj); // 공유객체 (shareObj) 사용
		Thread readThread = new SynchReadNumber(shareObj);	   //-> synchronized 쓸 수밖에없음
		
		changeThread.start();
		readThread.start();

	}

}
