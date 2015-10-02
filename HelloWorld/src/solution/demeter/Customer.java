package solution.demeter;

/**
 * Customer 고객은 오직 창구직원을 통해서만 입금과 출금을 할 수 있다.
 * @author Administrator
 *
 */
public class Customer {
	
	private String customerCode;
	
	private int money;
	
	private Teller teller;
	
	public Customer(String customerCode, int money) {
		teller = new Teller();
		this.money = money;
		this.customerCode = customerCode;
		teller.createCustomer(customerCode, money);
	}
	/**
	 * 출금
	 * @param value 츨금액
	 * @return 출금 성공 여부
	 */
	public boolean withdrawal(int value) {
		if(teller.withdrawal(customerCode, value)) {
			money += value;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 입금
	 * @param value 입금액
	 * @return 입금 성공 여부
	 */
	public boolean deposit(int value) {
		if(teller.deposit(customerCode, value)) {
			money -= value;
			return true;
		} else {
			return false;
		}
	}
	
	public int getBalance() {
		return money;
	}
	
}
