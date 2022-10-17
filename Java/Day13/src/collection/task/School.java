package collection.task;

import java.util.ArrayList;
import java.util.Scanner;

public class School {
	public static void main(String[] args) {

		StudentField sf = new StudentField();
		Scanner sc = new Scanner(System.in);
		String msgMenu = "아래의 메뉴중 한 개를 골라주세요\n"
				+ "1. 학생 추가\n2. 학생 점수 수정\n3. 이름 검색\n4. 번호 검색\n5. 학생 삭제\n"
				+ "6. 학생 목록\n7. 학생 검색\n8. 나가기";
		int choice = 0;
		
	    
		//      ===========================================
		String msg = "번호\t이름\t국어\t영어\t수학\t총점\t평균";
		// 출력할 목록들을 보여주는 메세지 
		
		String[] subjects = {"국어", "영어", "수학"};
		// 각 과목들이 담겨있는 스트링 
		String name = null;
		// 학생의 이름 
		int num = 0;
		// 학생 번호 
		int subjectNumber = 0;
		// 과목 번호 (스캐너로 입력 받을 번호)
		int score = 0;
		// 수정할 점수 (스캐너로 입력 받을 점수) 
		ArrayList<Student> students = null;
		// students 라는 ArrayList 를 만들어줌 
	
		Student student = new Student();
		// student 라는 Student Class 를 만들어줌 

		//============================================
			      
		
		while (true) {
			System.out.println(msgMenu);
			choice = sc.nextInt();
			String nameReal = null;
			int koreanScore = 0, englishScore = 0, mathsScore = 0;
			
			if (choice == 8) {break;}
			
			switch (choice) {
			case 1: // 학생 추가
				System.out.println("등록하고자 하는 학생의 이름을 입력해주세요: ");
				nameReal = sc.next();
				System.out.printf("%s 학생 의 국어 점수를 입력해주세요: ", nameReal);
				koreanScore = sc.nextInt();
				System.out.printf("%s 학생 의 영어 점수를 입력해주세요: ", nameReal);
				englishScore = sc.nextInt();
				System.out.printf("%s 학생 의 수학 점수를 입력해주세요: ", nameReal);
				mathsScore = sc.nextInt();
				
				Student std = new Student(nameReal);
				
				int[] arScore = {koreanScore, englishScore, mathsScore};
				
				std.setArScore(arScore);

				sf.insert(std);
				System.out.printf("%s 학생 의 등록이 완료되었습니다.\n", nameReal);
				
				break;
			case 2: // 학생 점수 수정

			      //사용자가 선택한 학생의 번호,
			      //선택한 과목, 입력한 점수로 수정 완성시키기
			      System.out.print("이름 : ");
			      name = sc.next();
			      // 이름을 스캐너로 입력받아 저장 
			      
			      students = sf.selectNames(name);
			      // 입력된 이름을 검색하는 메소드 
			      // (selectNames 로 리턴된 어레이리스트는 students 에 저장됨) 
			      
			      if(students.size() > 1) {//동명이인이 있을 때
			         System.out.println(msg);
			         // 출력할 값들의 목록을 출력하고 
			         for (int i = 0; i < students.size(); i++) {
			        	// 동명이인이 담긴 students ArrayList 가 끝날 때 
			            System.out.println(students.get(i));
			            // 학생 한 명의 데이터씩 출력한다 
			         }
			         num = sc.nextInt() + 1;
			         // 학생 수가 중복이고 여기서 한 명을 선택해야하니까 그것을 스캐너로 받음 
			       //학생 번호 1씩 증가하는 건 인스턴스 블럭에서 만들었던 것임 (1씩 증가) 
			         
			      }else if(students.size() != 0) {//동명이인이 없을 때
			         num = sf.getNumOfStudent(name);
			         // 한명이니까 이름으로 번호 검색 가능  => num 에는 학생 번호가 담겨있다
			         
			      }else {//학생이 없을 때
			         System.out.println("검색 결과가 없습니다.");
			      }
			      
			      if(num != 0) { //학생이 한 명이라도 있을 때
			         System.out.println("수정하실 과목을 선택하세요");
			         for (int i = 0; i < subjects.length; i++) {
			        	 // 과목들이 담겨있는 배열이 끝날 때 까지 
			            System.out.println(i + 1 + ". " + subjects[i]);
			            // 과목들을 전부 출력하고 
			         }
			         
			         subjectNumber = sc.nextInt();
			         // 스캐너로 사용자가 선택하게 함 
			         
			         System.out.print(subjects[subjectNumber - 1] + " 점수 : ");
			         // 수정할 과목 + 점수 : 출력 
			         score = sc.nextInt();
			         // 수정할 점수 스캐너로 입력 받음 
			         
			         student = sf.getStudent(num);
			         // 번호를 알고있으니 번호로 학생을 검색하여 해당 학생의 Class return 
			         student.getArScore()[subjectNumber - 1] = score;
			         // 해당 학생의 점수[과목의 배열] = 새 점수 => 변경 완료
			         // 사실 여기서 바로 DB 주소에 접근해 수정하기 때문에 sf.update()를 쓸 필요는 없음 
			         if(sf.update(student)) {
			        	 // 업데이트가 가능하면 
			            System.out.println("수정 성공");
			            //수정 성공 출력 
			            System.out.println(msg);
			            System.out.println(student);
			            // 목록과 업데이트된 학생의 점수 출력 
			         }else {
			            System.out.println("수정 실패");
			            // 업데이트가 불가능하면 수정 실패 출력 
			         }
			      }
				break;
				
			case 3: // 이름 검색
				System.out.print("이름 : ");
			      name = sc.next();
			      // 이름을 스캐너로 입력받아 저장 
			
				 students = sf.selectNames(name);
			      // 입력된 이름을 검색하는 메소드 
			      // (selectNames 로 리턴된 어레이리스트는 students 에 저장됨) 
				 
				 //System.out.println(msg);
		        //  System.out.println(students);
				 
			      if(students.size() > 1) {//동명이인이 있을 때
			         System.out.println(msg);
			         // 출력할 값들의 목록을 출력하고 
			         for (int i = 0; i < students.size(); i++) {
			        	// 동명이인이 담긴 students ArrayList 가 끝날 때 
			            System.out.println(students.get(i));
			            // 학생 한 명의 데이터씩 출력한다 
			         }
			      }else if(students.size() != 0) {//동명이인이 없을 때
			    	  System.out.println(msg);
				         // 출력할 값들의 목록을 출력하고 
			    	  System.out.println(students.get(0));
			         // 한명이니까 0번째가 해당 학생
			         
			      }else {//학생이 없을 때
			         System.out.println("검색 결과가 없습니다.");
			      }
			      
				break;
				
				
			case 4: // 번호 검색
				 System.out.print("이름 : ");
				 name = sc.next();
			      
				 students = sf.selectNames(name);
			      
			      if(students.size() > 1) {//동명이인이 있을 때
			         System.out.println(msg);
			         for (int i = 0; i < students.size(); i++) {
			            //학생들의 정보 출력
			            System.out.println(students.get(i));
			         }
			      }else if(students.size() != 0) {//동명이인이 없을 때
			    	  System.out.println(msg);
				         // 출력할 값들의 목록을 출력하고 
			    	  System.out.println(students.get(0));
			         // 한명이니까 0번째가 해당 학생
			      }else {//학생이 없을 때
			         System.out.println("검색 결과가 없습니다.");
			      }
			 //     System.out.println("학생의 번호를 확인해주십시오.");
				break;
				
				
			case 5: // 학생 삭제
			      //사용자가 선택한 학생의 번호,
			      //선택한 과목, 입력한 점수로 수정 완성시키기
			      
			      //삭제
			      System.out.print("이름 : ");
			      name = sc.next();
			      
			      students = sf.selectNames(name);
			      
			      if(students.size() > 1) {//동명이인이 있을 때
			         System.out.println(msg);
			         for (int i = 0; i < students.size(); i++) {
			            //학생들의 정보 출력
			            System.out.println(students.get(i));
			         }
			         //사용자가 수정하고 싶은 학생 번호 입력
			         num = sc.nextInt() + 1;
			         // + 1 해주는 이유는 인스턴스 블럭에서 초기에 +1 이 되었기 때문에 (2부터 시작) 
			         // 사용자에게 출력되는 숫자와 다름 (1부터 시작)
			         
			      }else if(students.size() != 0) {//동명이인이 없을 때
			         //같은 이름이 없기 때문에 이름으로 해당 학생의 번호 검사
			         num = sf.getNumOfStudent(name);
			         
			      }else {//학생이 없을 때
			         System.out.println("검색 결과가 없습니다.");
			      }
			      
			      if(num != 0) { //학생이 한 명이라도 있을 때
			         if(sf.delete(num)) {
			            System.out.println("삭제 성공");
			            System.out.println(msg);
			            
			            students = sf.selectAll();
			            
			            for (int i = 0; i < students.size(); i++) {
			               System.out.println(students.get(i));
			            }
			         }else {
			            System.out.println("삭제 실패");
			         }
			      }
				break;
				
			case 6: // 학생 목록 
				 System.out.println(msg);
			      students = sf.selectAll();
		      for (int i = 0; i < students.size(); i++) {
			            System.out.println(students.get(i));
		      }
				break;
				
			case 7: // 학생 검색 
				 System.out.print("번호 : ");
			      num = sc.nextInt() + 1;
			      
			      student = sf.getStudent(num);
			      System.out.println(msg);
		          System.out.println(student);
				break;
			}
		}
	}
}
	
	



