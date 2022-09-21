package test.run;

import test.common.Buffer;
import test.synch.Consumer;
import test.synch.Producer;

public class ProducerConsumerTest {

	public static void main(String[] args) {

		Buffer buffer = new Buffer();
		
		// Runnable 방법 사용시
		(new Thread(new Producer(buffer))).start(); // 공유객체 buffer
		(new Thread(new Consumer(buffer))).start();
		
//		Thread t1 = new Thread(new Producer(buffer));
//		Thread t2 = new Thread(new Consumer(buffer));
//		t1.start();
//		t2.start();
	}

}
