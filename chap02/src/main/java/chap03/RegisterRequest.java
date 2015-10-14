package chap03;

/**
 * 회원가입을 처리할 때 필요한 이메일, 암호, 이름 데이터를 담고 있는 클래스
 * @author 
 *
 */
public class RegisterRequest {
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public RegisterRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public RegisterRequest(String email, String password,
			String confirmPassword, String name) {
		super();
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.name = name;
	}
	
	String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email = email;
	}
	String getPassword() {
		return password;
	}
	void setPassword(String password) {
		this.password = password;
	}
	String getConfirmPassword() {
		return confirmPassword;
	}
	void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}
	
}
