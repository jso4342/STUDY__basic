package sync;

public class CU {
	public static void main(String[] args) {
		ATM atm = new ATM(); 
		// ㄴ 자원 : 쓰레드가 접근하는 쪽  
		
		Thread mom = new Thread(atm, "엄마");
		Thread son= new Thread(atm, "아들");
		
		mom.start();
		son.start();
		
	}

}
