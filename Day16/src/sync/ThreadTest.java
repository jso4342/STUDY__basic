package sync;

public class ThreadTest implements Runnable{
   @Override
   public void run() {
      while(true) {
         System.out.println("실행중...");
         System.out.println(Thread.interrupted());
         if(Thread.interrupted()) {System.out.println("종료됨..."); break;}
      }
   }
}