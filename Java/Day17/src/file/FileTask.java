package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
public static void main(String[] args) throws IOException{
	// food.txt 파일을 현재 경로에 생성하고
	// 파일 내용은 족발,보쌈, 짜장면, 탕수육 네 가지 음식으로 작성\
	//각 음식은 줄바꿈 다음 음식을 넣는다 
	
	//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("food.txt"), true));

	BufferedWriter bw = new BufferedWriter(new FileWriter(new File("food.txt"), true));
	String[] foods = {"족발", "보쌈", "짜장면"};
	
	for (int i = 0; i<foods.length; i++){
		bw.write(foods[i] + "\n");
		}
		bw.close(); 
		
	//bw.write("짜장면\n");
	//bw.write("탕수육\n");

	
	// 작성한 내용 콘솔에 출력 
	
	
	
	
	/*

	BufferedReader br = null; // writer 과 다르게 예외 설정을 한 번 더 해줘야함 
	String line = null;
	try {
		br = new BufferedReader(new FileReader("food.txt"));
		
		while((line = br.readLine())!= null) {
			System.out.print(line);
			// line 에 담는 이유: 한번 쓸 때 마다 뒤로 넘어가니까  
			// sc.next 같은 거임 
		}
		//br.readLine();
	} catch (FileNotFoundException e) {
		System.out.println("없는 파일 입니다.");
	} finally {
		if (br != null) {
			br.close();
		}
	}
	*/
	
	/*
	File f = new File("food.txt");
	if (f.exists()) {
		f.delete();
	
	System.out.println("삭제완");
	
	}
	*/
}
}
