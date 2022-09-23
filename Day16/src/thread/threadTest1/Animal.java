package thread.threadTest1;

public class Animal extends Thread{
	  
	   @Override
	   public void run() {
	      for (int i = 0; i < 10; i++) {
	         System.out.println(Thread.currentThread().getName());
	         try {Thread.sleep(100);} catch (InterruptedException e) {;}
	      }
	   }
}
