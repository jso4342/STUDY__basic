package collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest{ //<T> {
	
//	T data;
	
public static void main(String[] args) {
	// <?> : 제네릭 (이름이 없는) ArrayList<E>
	ArrayList<Integer>arList = new ArrayList<>();
	// <> 안에 뭐가 들어갈 지 모름. 단, class 타입만 쓸 수 있음. 디폴트가 Object 이기 때문 
	// 제네릭은 자식들만 받아 타입에 제한을 둘 수 있음 (Object 는 다 받아야함) 
	      arList.add(10);
	      arList.add(20);
	      arList.add(40);
	      arList.add(50);
	      arList.add(90);
	      arList.add(80);
	      arList.add(70);
	      arList.add(90);

	/*
	for (int i = 0; i < arList.size(); i++) {
		System.out.println(arList.get(i));
	}
	*/
	
	Collections.sort(arList);
				//  ------- 업캐스팅
	// sort 에서 주소값에 가서 바꾸기때문에  sort 가 void 여도 괜찮다 
	
	
	System.out.println(arList);
	System.out.println(arList.toString());
	Collections.reverse(arList);
	System.out.println(arList);
	Collections.shuffle(arList);
	System.out.println(arList);
	
	
	// 클래스는 Collections 이고 인터페이스는 Collection 
	
	System.out.println("-----------------------");
	   
    // 추가(삽입)
    // 50 뒤에 500 삽입
	
	/*
	for(int i = 0; i < arList.size(); i++){
		int k = arList.lastIndexOf(50);
		
		if (k == -1) {
			System.out.println("50이 없습니다.");
			break;
		}
		if (i == k) {
			arList.add(k + 1, 500);
			break;}
	}
	*/
	if (arList.contains(50)) {
		arList.add(arList.indexOf(50) + 1, 500);
	}
	System.out.println(arList);
	
    
    // 수정
    // 90을 9로 수정
	if (arList.contains(90)) {
		arList.set(arList.indexOf(90), 9);
	}
	System.out.println(arList);
	
    // 삭제
    // 80 삭제
    // 1. 인덱스로 삭제
	/*
	if (arList.contains(80)) {
		int result = arList.remove(arList.indexOf(80));
		System.out.println(result + "이 삭제되었습니다.\n" + arList);
		// integer -> int : unboxing 
	}
	*/
    // 2. 값으로 삭제
	if (arList.remove(Integer.valueOf(80))) { // boxing ->  근데 별로 안씀 
		//			or ((Object)80)
		System.out.println(arList);
	}
	
}
}
