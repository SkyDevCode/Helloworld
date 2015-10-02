package problem.coupling;

import java.util.HashMap;
import java.util.Map;

/**
 * 고객의 예금을 관리하는 은행 객체
 * @author Administrator
 *
 */
public class Bank {

	// 은행 금고가 공개돼 있어 어디서든 직접적인 접근이 가능
	public Map<String, Integer> safe;
	
	public Bank() {
		safe = new HashMap<String, Integer>();
	}
}
