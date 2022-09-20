package test.synch;

import java.util.Random;

public class AccountManager extends Thread {

	// 필드
	private Account ac; // AccountManager 객체 생성시 Account 객체도 생성
	private String threadName;

	// 생성자
	public AccountManager() {
	}

	public AccountManager(String threadName) {
		this.threadName = threadName;
		ac = new Account();
		Account.setBalance(1000);
	}

	// 스레드
	@Override
	public void run() {

		while (Account.getBalance() > 0) {
			System.out.println("현재 잔액 : " + Account.getBalance());
			
			// 출금할 돈을 랜덤으로 처리함 : 백원 단위로 함
			int money = (new Random().nextInt(10)+1) * 100; // Random().nextInt(10) : 0<=X<10
			System.out.println(threadName + "이/가 출금할 돈 : " + money);
			int result = ac.withDraw(money);
			System.out.println(threadName + "이/가 출금된 돈 : " + result);
		}

	}

}
