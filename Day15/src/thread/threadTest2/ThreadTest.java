package thread.threadTest2;

public class ThreadTest {
public static void main(String[] args) {
	
	ThreadTask t1 = new ThreadTask();
	ThreadTask t2 = new ThreadTask();
	ThreadTask t3 = new ThreadTask();
	
	Thread thread1 = new Thread(t1, "first");
	Thread thread2 = new Thread(t2, "second");
	Thread thread3 = new Thread(t3, "third");
	
	thread1.start();
	thread2.start();
	thread3.start();
	
	
	
	
	/*
	 * [실습]
Thread1, Thread2, Thread3 은 항상 순서대로 실행된다
출력 시 반드시 위의 순서를 지켜서 출력되어야 한다.
입력 예) 
	1 3 2
출력 예)
	1번 쓰레드 : first
	2번 쓰레드 : third
	3번 쓰레드 : second 

* 람다식을 최소 3번 사용한다. 
	 */
}
}
