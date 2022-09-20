package test.synch;

public class Account {

	// 필드
	private static int balance; // 잔액. 입금스레드와 출금스레드가 함께 사용할 공유자원
	
	// 메소드
	public synchronized int withDraw(int money) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 출금메소드
//		synchronized (this) {
			if(balance >= money) {
				balance -= money;
				System.out.println("출금성공 : "+ money);
				return money;
			} else {
				System.out.println("출금실패");
				return -1;
			}
//		}
	}

	// 게터세터
	public static int getBalance() {
		return balance;
	}

	public static void setBalance(int balance) {
		Account.balance = balance;
	}
	
	
}
