package test.synch;

import test.common.Buffer;

public class Consumer implements Runnable {

	private Buffer buffer; // Producer와 공유객체

	public Consumer(Buffer drop) {
		this.buffer = drop;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			int data = buffer.get();
			System.out.println("소비자: " + data + "번 케익을 소비하였습니다.");
			try {
				Thread.sleep((int)(Math.random()*100)); // Math.random() : 0 <= x < 1
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
