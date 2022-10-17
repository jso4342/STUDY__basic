package lambda;

import java.util.Scanner;

public class StreamTask {
	public static void main(String[] args) {
		
		/*
		//1) 1~10 까지 ArrayList 에 담고 출력 (IntStream)
		ArrayList<Integer> datas = new ArrayList<>();
		IntStream.range(0, 10).forEach(i -> datas.add(i + 1));
		System.out.println(datas);
	
		 
		//2) 1~100까지 중 짝수만 ArrayList 에 담고 출력 (filter) 
		ArrayList<Integer> datasOne = new ArrayList<>();
		IntStream.range(0, 100).filter(i -> i%2 != 0).forEach(i -> datasOne.add(i + 1));
		System.out.println(datasOne);
		//IntStream.range(1, 51).map(i -> i *2).forEacu(i -> dataOne.add(i));
		
		
		//3) A~F까지 ArrayList 에 담고 출력 (IntStream.range(), forEach, map) 
		ArrayList<Character> data = new ArrayList<>();
	      IntStream.range(65, 71).forEach(c->data.add((char)c));
	      System.out.println(data);
	
	      
		//4) A~F까지 중 D 제외하고 ArrayList에 담은 후 출력 (IntStream, map, 삼항 연산자 ) 
	      ArrayList<Character> dataa = new ArrayList<>();
	      IntStream.range(65, 71).filter(c -> c != 68).forEach(c->dataa.add((char)c));
	      System.out.println(dataa);
		
		*/
		
		//5) 5개의 정수를 입력받은 후 ArrayList에 담고 최대값과 최소값 출력(구글링)(Sort or mapToInt)
		/*
	      ArrayList<Integer> intData = new ArrayList<>();
	      String msg = "5개 정수를 입력해주세요.\n예)1 2 3 4 5";
	      Scanner sc = new Scanner(System.in);
	      System.out.println(msg);
	      
	      IntStream.range(0, 5).map(i -> sc.nextInt()).sorted().forEach(i -> intData.add(i));
	  
	      System.out.println("최소값: " + intData.get(0));
	      System.out.println("최대값: " + intData.get(4));
	      //IntStream().mapToInt(i -> i).max().getAsInt());
	      //IntStream().mapToInt(i -> i).min().getAsInt());
	       * 
	       * List<Integer> maxAndMin = datas.stream().sorted().collect(Collectors.toList());
	       *  System.out.println("최대값: " + maxAndMin.get(maxAndMin.size() - 1);
	       *  System.out.println("최소값: " + intData.get(0));
	  */    
		
		 
		 //6) 문자열을 5개 입력받고 모두 소문자로 변경 (IntStream, map)
		/*
		 ArrayList<String> stringData = new ArrayList<>();
	      String msg = "문자열 5개를 입력해주세요.\n예 )Hello my name is Seoyoung";
	      Scanner sc = new Scanner(System.in);
	      ArrayList<String> data = new ArrayList<>();
	      System.out.println(msg);
	      for (int i = 0; i < 5; i++) {
	    	  data.add(sc.next());
	      }
	      data.stream().map(String::toLowerCase).collect(Collectors.toList()).forEach(System.out::println);
	    */  
		
		 
		//7) Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력 (Arrays.asList(), filter, collect) 
		// ArrayList<String> dataFruits = new ArrayList<>(Arrays.asList("Apple", "banana", "Melon"));
		// dataFruits.stream().filter(c -> (c.charAt(0) < 97 || c.charAt(0) > 122)).forEach(System.out::println);
		 
	      
		//8) 한글을 정수로 변경 (map) 
		/*
		String hangle = "공일이삼사오육칠팔구";
		 Scanner sc = new Scanner(System.in);
		 System.out.println("입력 : ");
		 String data = sc.next();
		 
		 data.chars().map(c -> hangle.indexOf(c)).forEach(System.out::print);
		*/
		 	
	
	// 9) 정수를 한글로 변경 (map, forEach)
	//String[] hangle = {"공","일","이","삼","사","오","육","칠","팔","구"};
	 Scanner sc = new Scanner(System.in);
	 String hangle = "공일이삼사오육칠팔구";
	// String output = "";
	 
	 System.out.println("입력 : ");
	 int num = sc.nextInt();
	 String output = Integer.toString(num); 
	 
	 output.chars().map(c -> c - 48).forEach(c -> System.out.print(hangle.charAt(c)));
	
	      
	}

}
