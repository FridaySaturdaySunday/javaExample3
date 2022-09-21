package test.synch2;

public class SharedData {

	private int number = 12;
	private volatile boolean isChanged; // volatile : 휘발성
	// 최적화(비휘발성) -> 메모리에 기록된 값을 계속 가져다 사용하는 것

	// 생성자
	public SharedData() {}

	// 게터세터
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isChanged() {
		return isChanged;
	}

	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}

	// 동기화 메소드 or 동기화 블록
	public /*synchronized*/ void calcNumber() {
		synchronized (this) {
			number *= 3;
			System.out.println("changed...." + number);
		}
	}
	
	public /*synchronized*/ void printNumber() {
		synchronized (this) {
			System.out.println("number : " + number);
		}
	}
}
