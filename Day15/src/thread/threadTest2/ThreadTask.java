package thread.threadTest2;

public class ThreadTask extends Thread implements Runnable{
	public ThreadTask() {;}
	
	// run 으로 멀티 쓰레드를 재정의 한 것임 
	public void printFirst(Runnable first) {
		first.run(); // 수정 금지 
	}
	
	public void printSecond(Runnable second) {
		second.run(); // 수정 금지 
	}
	
	public void printThird(Runnable third) {
		third.run(); // 수정 금지 
	}
}
