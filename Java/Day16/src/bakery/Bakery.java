/*
package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {

   public static void main(String[] args) {
      BreadMaker maker = new BreadMaker();
      BreadPlate plate = BreadPlate.getInstance();
      Thread makerThread = new Thread(maker);
      
      String[] btns = {"๋นต ๋จน๊ธฐ๐ฅ", "๋๊ฐ๊ธฐ"};
      
      ImageIcon icon = new ImageIcon("src/img/bread.gif");
      
      
      makerThread.start();
      
      int choice = 0;
      while(true) {
         choice = JOptionPane.showOptionDialog(null, "", "๐๐ฅฏ์ข๋ง์ ๋นต๐ฅ๐ฅ", 
 				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
 				icon, btns, null);
      // static keyword ๋ฅผ ์ด๊ฑฐ์. ๊ฐ์ฒดํ ์์ด ๋ฐ๋ก ์ ๊ทผํ์ผ๋๊น 
         
         if(choice == 0) {
            plate.eatBread();
         }else {
        	 System.out.println("๋นต์ง์ ๋๊ฐ๋๋ค.");
        	 System.exit(0);
        	 //makerThread.stop();
        	 //makerThread.interrupt(); 
        	 			// --------- ๋ฉ์ถฐ์์ ๋ (sleep) interrupt ๋ฅผ ๋ฐ์์์ผ ํ์ถ 
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
      BreadPlate plate = BreadPlate.getInstance(); // ๋นต ๋ง๋๋ ๋ฉ์๋ 
      Thread makerThread = new Thread(maker); // ์ฐ๋ ๋ ๋ง๋ค๊ธฐ 
      
      String[] btns = {"๋นต ๋จน๊ธฐ", "๋๊ฐ๊ธฐ"};
      
      ImageIcon icon = new ImageIcon("src/img/bread2.gif");
      
      makerThread.start();
      
      int choice = 0;
      while(true) {
         choice = JOptionPane.showOptionDialog(null, "", "๋นต์ง", JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE, icon, btns, null);
         
         if(choice == 0) {
            plate.eatBread();
           //System.out.println("์ํ");
         }else {
            //๋นต ๋ง๋ค๊ธฐ ์ฐ๋ ๋ ์ข๋ฃํ๊ธฐ(๋ณ์๋ก ํด๊ฒฐ)
//            maker.setExit(true);
//            makerThread.interrupt();
            System.exit(0);
            break;
         }
      }
   }
}

