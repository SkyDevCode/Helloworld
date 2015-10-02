package solution.demeter;

import java.util.HashMap;
import java.util.Map;

/**
 * Bank : 은행 금고에 접근할 수 있는 권한은 은행만 갖고 있다. 
 * @author Administrator
 *
 */
public class Bank {

	// 은행 금고에는 절대 직접 접근할 수 없다.
	private Map<String, Integer> safe;
	
	public Bank() {
		safe = new HashMap<String, Integer>();
	}
	
	private boolean isCustomer(String customerCode) {
		return safe.containsKey(customerCode);
	}
	
	private boolean isEnable(String customerCode, int value) {
		return safe.get(customerCode) >= value;
	}
	
	/**
	 * 출금
	 * @param customerCode 고객 코드
	 * @param value 출금액
	 * @return 성공 여부
	 */
	public boolean widtrawal(String customerCode, int value) {
		//등록된 고객이 아니면 출금할 수 없다.
		if(!isCustomer(customerCode)) {
			return false;
		}
		
		// 잔액이 부족하면 출금할 수 없다.
		if(!isEnable(customerCode, value)) {
			return false;
		}
		
		int balance = safe.get(customerCode) - value;
		safe.remove(customerCode);
		safe.put(customerCode, balance);
		
		return true;
	}
	
	/**
	 * 입금
	 * @param customerCode 고객코드
	 * @param value 입금액
	 * @return 성공여부
	 */
	public boolean deposit(String customerCode, int value) {
		//등록된 공객이 아니면 입금할 수 없다.
		if(!isCustomer(customerCode)) {
			return false;
		}
		
		int balance = safe.get(customerCode) + value;
		safe.remove(customerCode);
		safe.put(customerCode, balance);
		
		return true;
	}
	
	public boolean createCustomer(String customerCode, int value) {
		//기존 고객이면 등록 불가
		if(isCustomer(customerCode)) {
			return false;
		}
		
		safe.put(customerCode, value);
		return true;
	}
	
}
