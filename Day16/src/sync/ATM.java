package sync;

public class ATM implements Runnable{
	int money = 10000;
	
	@Override
	public void run() {
		for (int i =0; i < 5 ; i++) {
			withdraw(1000);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {;}
		}
		
	}
	
	public synchronized void withdraw(int money) {
		// 알트 쉬프트 제트 
		//synchronized (this) { // 소스코드 하나에 동기화 걸어주기 
			this.money -= money;
		//}

		System.out.println(Thread.currentThread().getName() + "이(가) " + money + "원 출금");
		System.out.println("현재 잔액 : " + this.money + "원");
		//근데 이러면 현재 잔액이 0원이 아님!!
		//멀티쓰레드는 속도가 빠르기 때문에 특정 연산 속도가 skip돼버림 (하기 전에 해버림) 
	}

}
