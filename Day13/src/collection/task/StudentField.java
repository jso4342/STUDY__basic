package collection.task;

import java.util.ArrayList;

public class StudentField {
	ArrayList<Student> students = new ArrayList<>();
	
	// 자료구자 DB
	// 학생 추가 (점수를 입력해주세요) 
	public void insert(Student std) {
			students.add(std);
	}
	
	// 학생 점수 수정 (이름) 
	// 여기서 학생 선택을 해야함 
	// 이름이 동명 이인이라면 (중복이 있다면) 중복을 출력해서
	// 사용자가 선택한 번호의 학생의 점수를 수정한다.
	// std 를 수정이 끝난 정보라고 생각해야함 
	public boolean update(Student std) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getNum() == std.getNum()) {
				students.set(i,  std);
				return true;
			}
		}
		return false;
	}
	
	// 이름 검색하는 메소드 (Student 리턴)
	// DB에서 이름을 조회한 후 검색된 모든 정보들을 리턴한다 
	public ArrayList<Student> selectNames(String name) {
		ArrayList<Student> sameName = new ArrayList<Student>();
		for (int i = 0; i < this.students.size(); i++) {
			if (this.students.get(i).getName().equals(name)) {
				// 지역변수인 students에 if 문에 들어온 i 번째 학생을 추가한다.
				 	sameName.add(this.students.get(i));
			    }
			}
		 return(sameName);
		}
	
	// 번호 검색 (이름)
	//중복이 없는 이름임
	// 이름으로 해당 학생의 번호를 검색한다 
	public int getNumOfStudent(String name) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(name)) {
				return students.get(i).getNum();	
			}
		}
		return -1;
	}
	
	// 학생 삭제 (이름)
	// 수정이랑 같은데 remove 
			// 동명이인 검색 후 사용  
			// 이름이 동명 이인이라면 (중복이 있다면) 중복을 출력해서
			// 사용자가 선택한 '번호'의 학생을 삭제한다.
			// 결국 삭제하는 건 학생의 번호 	
	 public boolean delete(int num) {
	      boolean result = false;
	      for (int i = 0; i < students.size(); i++) {
	         if(students.get(i).getNum() == num) {
	            result = students.remove(students.get(i));
	         }
	      }
	      return result;
	   }

	
	//학생 목록(전체)
		public ArrayList<Student> selectAll() {
			ArrayList<Student> students = new ArrayList<>();
			for (int i = 0; i < this.students.size(); i++) {
				students.add(this.students.get(i));
			}
			return students;
		}
	
	// 학생 검색 (번호로 ) 
	public Student getStudent(int num) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getNum() == num) {
				return students.get(i);
			}
		}
		return null;
	}

	
}
