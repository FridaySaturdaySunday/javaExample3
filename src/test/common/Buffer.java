package test.common;

public class Buffer {

//	wait() - 락을 반납하고 통지를 대기
//	wait(long millis) - 락을 반납하고 밀리초만큼 대기
//	wait(long millis, int nanos) - 락을 반납하고 밀리초+나노초만큼 대기
//	notify() - 객체 대기 풀의 임의의 스레드에 통지
//	notifyAll() - 객체 대기 풀의 모든 스레드에 통지

	private int data;
	private boolean empty = true;
	
	// 케익 없을때 - consumer 기다리게했다가 가져가게함
	public synchronized int get() {
		while (empty) {
			try {
				wait(); // 대기해!!
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = true;
		notifyAll(); // 일어나!!
		return data;
	}
	
	// 케익 있을때 - producer 안만들게했다가 만들게함
	public synchronized void put(int data) {
		while (!empty) {
			try {
				wait(); // 대기해!!
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = false;
		this.data = data;
		notifyAll(); // 일어나!!
	}
	
}
