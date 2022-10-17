package wrapper;

public class WrapperTest {
public static void main(String[] args) {
	int data_i = 10; 
	
	
//	Integer data_I = new Integer(data_i);
	// boxing
	
	Integer data_I = data_i;
	// auto boxing
	
	
//	data_i = data_I.intValue();
	//unboxing
	
	data_i = data_I;
	//auto unboxing

}
}
