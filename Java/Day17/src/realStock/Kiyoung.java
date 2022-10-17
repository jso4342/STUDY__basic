package realStock;

import java.util.Random;

public class Kiyoung extends Bank implements Runnable{
	
	private static Kiyoung kiyoung;
	
	static int stockMoney = 0; // 주식에 투자하는 돈 (수익률을 반영한 돈)  
	static int depositMoney = 0; // 초기 자금 (투자 자금) 
	static int stockPrice = 1000; // 기영전자의 처음 가격 
	static int numStock = 0; // 주식 갯수 
	
	@Override
	public void deposit(int money) {
		money *= 0.5;
		super.deposit(money);
	}
	
	//주식
	
	// 상장폐지 
	public boolean stock() { // 주식이 상장 폐지 되었는지를 확인하고 
							// 폐지되지 않았다면 내 주식 잔액을 퍼센트에 맞게 변경
							// 24시간 돌아가야함 
		Random r = new Random();
		// 랜덤한 퍼센트 
		int rating = 0;
		
		if (r.nextInt(100)== 0) {
			stockPrice = 0;
			stockMoney = 0;
			System.out.println("상장이 폐지되었습니다. 바람을 쐬고 오세요.");
			return false;
			// 상장 폐지 -> false 이면 상장폐지 
		}
		
		 if (r.nextInt(2) == 0) {
	         rating = r.nextInt(30) + 1;
	      } else {
	         rating = -(r.nextInt(30) + 1);
	      }
		 stockPrice *= (100 + rating)* 0.01;
		 stockMoney *= (100 + rating)* 0.01;
	      return true;
	   }

	
	public static int buyStock() { // 매수 
		if (stockPrice > StockMarket.money) {
			// 잔고 확인 
			return -1;
		}
			
		else {
			try {
				depositMoney += stockPrice; // 초기 투자 자금 
				stockMoney += stockPrice; // 현재 가격 = 현재 가격 +매수가 
				StockMarket.money -= stockPrice; 
				numStock = numStock + 1;
				// money 수정 필요 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
	}
}
	
	public static int sellStock() { // 매도 
		  
		if (numStock != 0) {
			
				try {
					depositMoney -= (depositMoney / numStock);
					// 내가 소지하고 있는 주의 평균값임 
					stockMoney -= stockPrice;
					StockMarket.money += stockPrice; 
					numStock = numStock - 1;
					// money 수정 필요 
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			
				return 1;
		}
		else
			return -1;
	}
	
	
	// 주식 현재 잔액
	
		
	// run() 재정의 

	@Override
	public void run() {
		// - 투자 금액은 전재산보다 작아야한다. 
		
		if(money >= depositMoney) {
			while(true) {
				if(!stock()) {break;}
				try {
					System.out.println(":::::::::::현재 기영전자의 가격 :" + stockPrice +"원");
					Thread.sleep(2000); // 매도할 타이밍 
				} catch (InterruptedException e) 
					// 주식을 그만 둘 때 catch 에 들어옴 
				{
					if (depositMoney != 0) {
						System.out.println("총 투자 원금 :" + depositMoney);
						// 주식 전 투자금액 출력 
						System.out.println("총 투자 자산 :" + stockMoney);
						// 주식 후 투자금액 출력 
						double percent = (((double)stockMoney / (double)depositMoney) - 1) * 100;
						System.out.println("투자 수익률: " + String.format("%.2f", percent) + "%");
						System.out.println("내 예수금: " + StockMarket.money + "원");
						System.exit(0);
						// 수익률 출력 
					}
					else {
						System.out.println("예수금을 포함한 내 자산 : " + (StockMarket.money + stockMoney) + "원");
						double percent = ((((double)StockMarket.money + (double)stockMoney) / (double)StockMarket.beginMoney) - 1) * 100;
						System.out.println("초기 예수금 대비 투자 수익률: " + String.format("%.2f", percent) + "%");
						System.exit(0);
						
					}
						
					
					// 매수 매도 클릭 … 
				}
			}
		
		}
		else
			System.out.println("잔액 부족");
		
	}
	

}