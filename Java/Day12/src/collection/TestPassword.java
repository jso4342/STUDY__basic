package collection;

public class TestPassword {

	
	
	public static String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * 3);
		}
		System.out.println("기존 비밀번호: " + pw + "\n암호화된 비밀번호: " + en_pw);
		return en_pw;
	}
	
	public static void main(String[] args) {
		String pw = "12345";
		
		encrypt(pw);
	}
}
