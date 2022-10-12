package wrapper;

public class WrapperTask {
public static void main(String[] args) {
	// 1, 3.5, 12.5F, 'A', "ABC", true
	// 위 6개의 값을 6칸 배열에 담기 
	
	// Integer, Double, Float, Character, String, Boolean 
	
	Object[] arData = {1, 3.5, 12.5F, 'A', "ABC", true};
	
	for (int i =0; i < arData.length; i++) {
		System.out.println(arData[i]);
	}
	/*
	int data_1 = 1;
	double data_2 = 3.5;
	float data_3 = 12.5F;
	Character data_4 = 'A';
	String data_5 = "ABC";
	boolean data_6 = true;
	
	Object data_a1 = data_1;
	Object data_a2 = data_2;
	Object data_a3 = data_3;
	Object data_a4 = data_4;
	Object data_a5 = data_5;
	Object data_a6 = data_6;
	
	System.out.println(data_a3);
	*/
}
}
