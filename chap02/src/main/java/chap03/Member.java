package chap03;

import java.util.Date;

public class Member {
	
	private Long id;	
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	
	public Member(String email, String password, String name, Date registerDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
	}

	void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public Date getRegisterDate() {
		return registerDate;
	}
	
	/**
	 * 기존 암호를 확인하고 새암호로 변경
	 * @param oldPassword
	 * @param newPassword
	 */
	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) {
			throw new IdPasswordNotMatchingException();
		}		
		this.password = newPassword;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", password="
				+ password + ", name=" + name + ", registerDate="
				+ registerDate + "]";
	}	
	
	
}
