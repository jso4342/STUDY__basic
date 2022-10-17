

package bakery;

public class BreadMaker implements Runnable{
	
	/*
	 private boolean running;
	 
     public boolean isRunning() {
   	  return running;
     }
     
     public void setRunning(boolean running) {
      	 this.running = running;
        }
     */
	
   @Override
   public void run() {
      //20개의 빵을 만드는 자원 구현   
      for (int i = 0; i < 20; i++) {
    //	  if (running) {break;}
         try {   Thread.sleep(500);} catch (InterruptedException e) {break;}
         BreadPlate.getInstance().makeBread();
 		//     A    ------------      B
		// 		 A 클래스에 있는 B 객체로 
         try {   Thread.sleep(500);} catch (InterruptedException e) {break;}
      
      }
      System.out.println("재료 소진");
      }
 //     if (!running) {
      
   }

