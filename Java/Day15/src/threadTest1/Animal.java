package threadTest1;

public class Animal {
	/*
	 * 동석이네 동물원에는 3마리의 동물이 있다.
	각 동물은 울음 소리가 다르고 2마리의 동물은 동시에 운다.

	나머지 1마리의 동물은 2마리 동물이 모두 울고 나서 마지막에 운다.

	package 명은 threadTest1 으로 만들고 클래스는 2개만 선언한다.
	하나의 클래스에는 main 쓰레드가 있다
	Runnable 인터페이스로 멀티 쓰레드를 구현하고 
	반드시 join() 을 사용한다.
	* 각 동물은 10번씩만 운다.
	 */
	
	public static void main(String[] args) {
		// 배열 써서 쓰기 
		
		Runnable[] animal = new Thread1[3];
		for(int i = 0; i < 3; i++) {
			animal[i] = new Thread();
		//	animal[i].start();
			
		}
		
	//	Thread animal = new Thread[0](dog, "왈왈");
		
	//	animal = {dog, cat, tiger};
		
		/*
		
		Runnable dog = new Thread1();
		Runnable cat = new Thread1();
		Thread1 tiger = new Thread1();
		*/
		
		/*
		 Thread t1 = new Thread(dog, "왈왈");
	     Thread t2 = new Thread(cat, "왜옹");
	     Thread t3 = new Thread(tiger, "어흥");
	     
	     t1.start();
	     t2.start();
	     
	     try {
	    	 t1.join();
		     t2.join();
	     }catch (InterruptedException e) {
	         e.printStackTrace();
	     }
	     t3.start();
		
	}
	*/
	}
}
