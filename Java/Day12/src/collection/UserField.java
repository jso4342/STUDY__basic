package collection;

import java.util.ArrayList;

public class UserField {
		
		ArrayList<User> users = new ArrayList<>();
		// 회원 정보를 저장할 자료구조 선언 -> 어레이리스트 
		
		public static final int KEY = 3;
		//암호키  
		
		// 아이디 중복검사
		// boolean 보다 User 타입으로 리턴하는 것이 좋다 
		public User checkId(String id) {
			User user = null;
			for (int i = 0; i < users.size(); i++) {
				// 모든 회원 정보 users 를 확인할 때 까지 
				if (users.get(i).getId().equals(id)) {
					// i 번쨰의 회원 정보에서 가져온 ID 가 입력된 id 와 같다면 
					user = users.get(i);
					// user 는 회원 정보의 I 번째 회원이다 
					break;
				}
			}
			return user;
		}
	

		// 회원가입
		public void join(User user) {
			user.setPw(encrypt(user.getPw()));
			// user 로 입력받은 비밀번호를 -> 암호화 한 뒤 -> setPw로 User 에 저장한 뒤 
			users.add(user);
			// 회원 정보에 저장 
		}
		
		
		// 로그인 
		// 아이디랑 비밀번호를 받아서 암호화된 비밀번호끼리 비교 
		public User logIn(String id, String pw) {
			User user = null;
			String password = encrypt(pw);
			
			for (int i = 0; i < users.size(); i++) {
				if ((users.get(i).getId().equals(id)) && 
						(users.get(i).getPw().equals(password))){
					 	user = users.get(i); 
					 	return user; 
				}
				else
					return null;
			}
			return null;
		}
			

		// 암호화
		public String encrypt(String pw) {
			String en_pw = "";
			for (int i = 0; i < pw.length(); i++) {
				en_pw += ((char)pw.charAt(i) * 3);
			}
			return en_pw;
		}
		
		
		/*
		public String finePw(String name, String phone) {
			String en_pw = null;
			for (int i = 0; i < users.size(); i++) {
				if ((users.get(i).getName().equals(name)) && (users.get(i).getPhone().equals(phone))){
					en_pw = users.get(i).getPw(); // 암호화 되어있는 비밀번호 
					
					String real_pw = "";
					for (int j = 0; j < en_pw.length(); j++) {
						
					}
				}
				else
					return null;
			}
			
			return password;
		}
		*/
		// 비밀번호 찾기(이름과 핸드폰 번호로 찾기, SMS로 비밀번호 전송)
		// 여기서는 복호화가 필요할 것 같음 
		
}
