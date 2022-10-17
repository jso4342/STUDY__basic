package bakery;

public class BreadPlate {
	
	private static BreadPlate plate;
	
	// 메소드 2개 빵 만들기, 먹기 
	int breadCount;
	int eatCount;
	
	// 싱글톤 패턴 (객체가 딱 한개만 존재!) 
	private BreadPlate() {;}
	
	public static BreadPlate getInstance() {
		if (plate == null) {
			plate = new BreadPlate();
		}
		return plate;
	}
	
	public synchronized void makeBread() {
		  if(breadCount > 9) {
		         System.out.println("빵이 가득 찼습니다.");
		         try {wait();} catch (InterruptedException e) {;}
		      }
		      breadCount++;
		      System.out.println("🍞빵을 1개 만들었습니다. 총 : " + breadCount + "개");
		   }

	
	
	public synchronized void eatBread() { // 메인 쓰레드 (쓰레드 2) 
		if (eatCount == 20) {
			System.out.println("❌ 빵이 품절되었습니다.");
		}else if (breadCount < 1) {
			System.out.println("🍩🍩🍪🍪빵을 만들고 있어요!🍪🍪🍩🍩");
		}
		else {
			breadCount--;
			eatCount++;
			System.out.println("🍰 빵을 1개 먹었습니다! 냠냠. 총 " + breadCount + "개");
			notify(); // wait 으로재워준 걸 깨워주는 부분
		}
	}

}
