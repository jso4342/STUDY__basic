package collection;

public class Student {
   int num;
   String name;
   
   public Student() {;}

   public Student(int num, String name) {
      this.num = num;
      this.name = name;
   }
   
  @Override
  // 주소가 아니라 번호로 비교를 하도록 equals 를 재정의 
	public boolean equals(Object obj) {
		if (this == obj) {return true;} // 주소 비교 
		if (obj instanceof Student) { // 타입 비교 
			Student std = (Student)obj; // 다운 캐스팅 
			if (std.num == this.num) {
				return true;
			}
		}
		return false;
	}
  
  // equals 를 재정의 했다면 반드시 hashCode 도 재정의 해야된다 
  @Override
	public int hashCode() {
		return this.num;
	}
}