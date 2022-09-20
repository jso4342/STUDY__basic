/*
package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {

   public static void main(String[] args) {
      BreadMaker maker = new BreadMaker();
      BreadPlate plate = BreadPlate.getInstance();
      Thread makerThread = new Thread(maker);
      
      String[] btns = {"빵 먹기🥐", "나가기"};
      
      ImageIcon icon = new ImageIcon("src/img/bread.gif");
      
      
      makerThread.start();
      
      int choice = 0;
      while(true) {
         choice = JOptionPane.showOptionDialog(null, "", "🍞🥯좐맛선빵🥐🥖", 
 				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
 				icon, btns, null);
      // static keyword 를 쓴거임. 객체화 없이 바로 접근했으니까 
         
         if(choice == 0) {
            plate.eatBread();
         }else {
        	 System.out.println("빵집을 나갑니다.");
        	 System.exit(0);
        	 //makerThread.stop();
        	 //makerThread.interrupt(); 
        	 			// --------- 멈춰있을 때 (sleep) interrupt 를 발생시켜 탈출 
        	// maker.setRunning(true);
            break;
         }
      }
   }
}
*/


package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {
   public static void main(String[] args) {
      BreadMaker maker = new BreadMaker(); // Kiyoung
      BreadPlate plate = BreadPlate.getInstance(); // 빵 만드는 메소드 
      Thread makerThread = new Thread(maker); // 쓰레드 만들기 
      
      String[] btns = {"빵 먹기", "나가기"};
      
      ImageIcon icon = new ImageIcon("src/img/bread2.gif");
      
      makerThread.start();
      
      int choice = 0;
      while(true) {
         choice = JOptionPane.showOptionDialog(null, "", "빵집", JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE, icon, btns, null);
         
         if(choice == 0) {
            plate.eatBread();
           //System.out.println("아하");
         }else {
            //빵 만들기 쓰레드 종료하기(변수로 해결)
//            maker.setExit(true);
//            makerThread.interrupt();
            System.exit(0);
            break;
         }
      }
   }
}

