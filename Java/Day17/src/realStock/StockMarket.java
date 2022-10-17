package realStock;

import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class StockMarket {
	
	  public static int money;
	  public static int beginMoney;
   public static void main(String[] args) {
	 
	   Kiyoung stock = new Kiyoung();
   	Thread stockThread = new Thread(stock);
   Scanner sc = new Scanner (System.in);
   	
   	String[] btns = {"매수", "매도", "나가기"};
   	System.out.println("예수금을 입력해주세요: ");
   	money = sc.nextInt();
   	beginMoney = money;
   
   	
   	ImageIcon icon = new ImageIcon("src/img/stockImage.jpg");
   	
   	stockThread.start();
   	int threadChoice = 0;
   	while(true) {
   		//System.out.println("스톡: " + stock.stockPrice);
   		threadChoice = JOptionPane.showOptionDialog(null, "한국 최고 기영 전자 입니다.", "*** 기영주식 투자센터 ***", JOptionPane.DEFAULT_OPTION,
   	            JOptionPane.PLAIN_MESSAGE, icon, btns, null);
   		
   		if (threadChoice == 0) {
   			int buyResult = Kiyoung.buyStock();
   			if (buyResult == -1)
   				System.out.println("잔액이 부족합니다.");
   			else {
       			System.out.println("주식이 매수되었습니다.");
       			System.out.println("총 투자금 :" + stock.depositMoney);
       			System.out.println("총 평가금 :" + stock.stockMoney);
       		
       			System.out.println("$$$$" + stock.numStock + "주를 소지하고 계십니다.");
   			}

   		}
   		else if (threadChoice == 1) {
   			int sellResult = Kiyoung.sellStock();
   			if (sellResult == 1) {
   				System.out.println("주식 매도되었습니다.");
   				System.out.println("총 투자금 :" + stock.depositMoney);
       			System.out.println("총 평가금 :" + stock.stockMoney);
     
       			System.out.println("$$$$" + stock.numStock + "주를 소지하고 계십니다.");
   			}
   			else
   				System.out.println("가지고 있는 주식이 없습니다.");
   		}
   		
   		else {
   			stockThread.interrupt();
   			//System.exit(0);
   			break;
   		}
   		
   	}
	}

}
/*
      String[] btns = {"매도하기", "나가기"};
      int choice  = 0;
      Scanner sc = new Scanner(System.in);
      Bank user = new Bank();
      Thread t = new Thread(user);
      
      System.out.println("투자액 : ");
      user.depositMoney = sc.nextInt();
      if(user.depositMoney > 0) {
         user.stockMoney = user.depositMoney;
         t.start();
         while(true) {
            choice = JOptionPane.showOptionDialog(null, "인생은 주식이다.", "주식마켓", JOptionPane.DEFAULT_OPTION,
                  JOptionPane.PLAIN_MESSAGE, null, btns, null);
            
            if(choice == 1) {
               System.exit(0);
            }
            
            if(choice == 0) {
               t.interrupt();
               try {t.join();} catch (InterruptedException e) {;}
               user.sell();
               break;
            }
         }
      }
   }
}
*/