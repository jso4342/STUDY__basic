package collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		HashSet<String> fruitSet = new HashSet<>();
		
	
		
		fruitSet.add("수박");
		fruitSet.add("수박");
		fruitSet.add("망고");
		fruitSet.add("복숭아");
		
		System.out.println(fruitSet);
		System.out.println(fruitSet.toString());
		// set 에는 순서가 없으나 toString 에 있는 
		// 이터레이터를 통해 순서를 만들어서 가져올 수 있다 
		// iterator는 fruitSet 을 객체로 사용 (this) 
		System.out.println(fruitSet.contains("수박"));
		
		
		// 밑에는 없어도 되지만 한 번 보자. 
		Iterator<String> iter = fruitSet.iterator();
		// 순서가 없어서 이터레이터로 순서를 만드는 것임
		// 기존에 순서가 있었어도 이터레이터의 순서로 변경된다 
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}
}
