package chap03;

public class ChangePasswordService {
	
	private MemberDao memberdao;
	
	public ChangePasswordService(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		
		Member member = memberdao.selectByEmail(email);
		if(member == null) { // 존재하지 않는 회원일경우 익셉션 발생
			throw new MemberNotFoundException();			
		}
		
		member.changePassword(oldPwd, newPwd);
		memberdao.update(member);
		
	}
}
