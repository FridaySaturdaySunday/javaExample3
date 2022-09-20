package test.run;

import test.common.Buffer;
import test.synch.Consumer;
import test.synch.Producer;

public class ProducerConsumerTest {

	public static void main(String[] args) {

		Buffer buffer = new Buffer();
		
		// Runnable 방법 사용시
		(new Thread(new Producer(buffer))).start();
		(new Thread(new Consumer(buffer))).start();
	}

}
