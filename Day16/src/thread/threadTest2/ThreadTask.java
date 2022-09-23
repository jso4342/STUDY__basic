package thread.threadTest2;

public class ThreadTask implements Runnable{
	
	public static int count = 0;
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
	
	@Override
	public void run() {
		switch(Thread.currentThread().getName()) {
		case "1":
			printFirst(() -> System.out.println(++count + "번 쓰레드 : first"));
			break;
		case "2":
			printSecond(() -> System.out.println(++count + "번 쓰레드 : second"));
			break;
		case "3":
			printThird(() -> System.out.println(++count + "번 쓰레드 : third"));
			break;
		}
	}
}
