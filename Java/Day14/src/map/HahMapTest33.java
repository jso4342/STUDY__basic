package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HahMapTest33 {
   public static void main(String[] args) {
      HashMap<Student, ArrayList<Integer>> studentMap = new HashMap<>();
      // 학생들의 정보가 담긴 StudentMap 이라는 해쉬맵 생성 
      
      Student std1 = new Student(1, "한동석");
      Student std2 = new Student(2, "홍길동");
      Student std3 = new Student(1, "이순신");
      
      Integer[] arData = {100, 90, 70};
      // 학생 한 명당 세 과목의 점수를 가지고 있음 
      ArrayList<Integer> std1Scores = new ArrayList<>(Arrays.asList(arData));
      // asList(T ...): 배열을 리스트로 변경시켜주는 메소드, 배열을 전달하지 않고 여러개의 값을 전달해도 List 로 전달해준다. 
   		// 근데 매번 배열 선언하기 귀찮음
      ArrayList<Integer> std2Scores = new ArrayList<>(Arrays.asList(100, 90, 70));
      // 그래서 이렇게 사용이 가능하다 
      ArrayList<Integer> std3Scores = new ArrayList<>(Arrays.asList(20, 50, 60));
      // Key 값이 동일한 위치의 밸류가 선언되어서 (1, value), 추가가 아니라 '수정' 이 되었음 
		
      
      studentMap.put(std1, std1Scores);
      // std1 에 std1Scores 를 밸류로 등록 
      studentMap.put(std2, std2Scores);
//      System.out.println(std1.equals(std3));
//      System.out.println(std1.hashCode() == std2.hashCode());
//      System.out.println(std1.hashCode() == std3.hashCode());
//      System.out.println(studentMap.containsKey(std3));
      
      //학생의 이름 변경
      Iterator<Student> iter = studentMap.keySet().iterator();
      // Iterator 를 만드는 이유: HashMap 에서는 Set 처럼 순서가 없기 때문에, 순서를 알기 위한 iter 를 만들어줌 
      // keySet() 를 하는 이유 : key 가 없으니까 key 만 분류한다 
      while(iter.hasNext()) {
    	  // 끝날 때 까지 
         Student std = iter.next();
         // 이름을 바꾸기 위해서는 학생의 번호를 알아야함 
         if(std.getNum() == std3.getNum()) {
            std.setName(std3.getName());
            // 이름을 이순신으로 수정한 세번째 학생과 동일한 키값을 발견하면 변경
            // std에 setName 하면 std3 에도 자동으로 수정된다. 
         }
      }
      
//      //학생 1번의 점수를 수정한다.
//      studentMap.put(std3, std3Scores);
//      System.out.println(studentMap);
      
//      빠른 for문(향상된 for문, forEach)
      
//      int[] datas = {3, 4, 5};
//      for(int data : datas) {
//         System.out.println(data);
//      }
      
      //학생별 점수와 평균 점수, 총 점(values())
      
      // 학생 수 만큼 배열 선언 
      int[] arTotal = new int[studentMap.size()];
      double[] arAvg = new double[studentMap.size()];
       
      int total = 0;
      //전체 점수 
      double avg = 0.0;	
      //전체 평균 
      int idx = 0;
      
      Collection<ArrayList<Integer>> scores = studentMap.values();
      // 어레이리스트를 여러개 담고 있는 게 Collection<ArrayList MInteger>> 
      // studentMap 의 모든 밸류들을 scores 에 담음. 그러니까 여기서는 점수들이 담겨있겠지 
      for(ArrayList<Integer> scoreList : scores) {
    	// 빠른 반복문으로 하나하나 int i = 0; ... i++ 해주기 귀찮으니까
    	// scores의 어레이리스트들이 이 차례대로 scoreList 에 들어간다 {100, 90, 80}
         for(int score : scoreList) {
        	 // score 에는 int 들이 차례차례 들어간다 100, 90, 80 
            arTotal[idx] += score;
            // 아래 total 과 같은 값인데 arTotal 이라는 배열에 인덱스에 따라 저장 
            total += score;
            // score 값을 다 더해서 저장 
            System.out.print(score + "\t");
         }
         arAvg[idx] = (double)arTotal[idx] / scoreList.size();
         // 학생 별 평균 구하기 
         arAvg[idx] = Double.parseDouble(String.format("%.2f", arAvg[idx]));
         			// double 로 만들어주는 것 
         
         avg =(double)total /  (scoreList.size() * studentMap.keySet().size());
         avg = Double.parseDouble(String.format("%.2f", avg));
         
         System.out.println(arAvg[idx] + "\t" + arTotal[idx]);
         
         idx++;
      }
      
      //전체 학생의 평균 점수보다 높은 학생을 찾아낸다(우수 학생으로 출력)
      Iterator<Entry<Student, ArrayList<Integer>>> iterator = studentMap.entrySet().iterator();
      String msg = "";
      String names = "";
      while(iterator.hasNext()) {
         Entry<Student, ArrayList<Integer>> entry = iterator.next();
         int stdTotal = 0;
         double stdAvg = 0.0;
         
         for(int score : entry.getValue()) {
            stdTotal += score;
         }
         stdAvg = (double)stdTotal / entry.getValue().size();
         msg = "우수 장학생 명단\n";
         if(stdAvg > avg) {
            names = entry.getKey().getName() + "\n";
         }
      }
      if(!names.equals("")) {
         System.out.print(msg + names);
      }else {
         System.out.println("우수 장학생이 없습니다.");
      }
   }
}


