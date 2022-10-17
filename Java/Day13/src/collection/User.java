package collection;



public class User {
// 접근자는 모두 private 으로 한다
//	이름, 아이디, 비밀번호, 핸드폰번호 
	
	private String name = null;
	private String id = null;
	private String pw = null;
	private String phone = null;
	
	public User() {;}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	/*
	public static User checkId(String account) {
		User user = null;
		for (int i = 0; i < User.length; i++) {
			for (int j = 0; j < arCount[i]; j++) {
				if(banks[i][j].account.equals(account)) {
					//중복이 있을 때
					user = banks[i][j];
					break;
				}
				if(j != arCount[i]) {break;}
			}
		}
		return user;
	}
	*/
}
