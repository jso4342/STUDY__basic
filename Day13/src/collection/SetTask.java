package collection;

import java.util.HashSet;

public class SetTask {
public static void main(String[] args) {
	HashSet<Student> set = new HashSet<>();
	Student std = new Student(1, "한동석");
	
	System.out.println(std.equals(new Student(1, "한동석")));
	
	set.add(std);
	set.add(new Student(1, "한동석"));
	
	System.out.println(set.size());
	// 단 이럴 경우 두개가 되게 된다 
	// 따라서 equals 를 재정의 했을 경우, hashCode 도 재정의 해줘야한다! 
}
}
