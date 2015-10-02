package solution.demeter;

/**
 * 창구직원만 은행에 접근할 수 있다.
 * @author Administrator
 *
 */
public class Teller {

	//창구직원만 직접 은행의 출금 절차에 접근할 수 있다.
	private Bank bank;
	
	public Teller() {
		bank = new Bank();
	}
	
	public boolean withdrawal(String customerCode, int value) {
		
		return bank.widtrawal(customerCode, value);
	}
	
	public boolean deposit(String customerCode, int value) {
		
		return bank.deposit(customerCode, value);
	}
	
	public boolean createCustomer(String customerCode, int value) {
		return bank.createCustomer(customerCode, value);
	}	
	
}
