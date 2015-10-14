package chap03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * DB대신 Map을 이용해서 구현
 * @author Administrator
 * 
 */
public class MemberDao {

	private static long nextId = 0;
	private Map<String, Member> map = new HashMap<String, Member>();
	
	public Member selectByEmail(String email) { 
		return map.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
		System.out.println(nextId + ":" + member);
	}
	
	public void update(Member member) {		
		map.put(member.getEmail(),  member);	
		System.out.println(member.getId() + ":" + member);
	}	
	
	public Collection<Member> selectAll() {
		return map.values();
	}	
}
