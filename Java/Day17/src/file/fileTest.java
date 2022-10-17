package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileTest {
	//throws : 예외 던지기 (일괄 처리)
	// 메소드 내에서 자주 발생하는 예외를 메소드를 사용하는 곳에서 한 번에 예외처리를 하고자 사

public static void main(String[] args) throws IOException{
	// 절대경로 : 어디서든지 찾아갈 수 있는 경로 
	// 상대경로 : 현재 위치를 기준으로 찾아가는 경로 
	
	/*
	BufferedWriter bw = new BufferedWriter(new FileWriter(new File("test.txt"), true)); // 이어쓰기 
	//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("test.txt"))); // 덮어쓰기 
	bw.write("\n장서영\n");

	bw.newLine();
	bw.write("장서영");
	bw.close();
*/
	BufferedReader br = null; // writer 과 다르게 예외 설정을 한 번 더 해줘야함 
	String line = null;
	try {
		br = new BufferedReader(new FileReader("test.txt"));
		
		while((line = br.readLine())!= null) {
			System.out.print(line);
		}
		//br.readLine();
	} catch (FileNotFoundException e) {
		System.out.println("없는 파일 입니다.");
	} finally {
		if (br != null) {
			br.close();
		}
	}
	
	
	
	
}
}
