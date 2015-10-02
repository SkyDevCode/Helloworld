package problem.coupling;

/**
 * 예금을 입출금하는 고객
 * @author Administrator
 *
 */
public class Customer {
	
	public String customerCode;
	
	public int money;
	
	public Teller teller;
	
	public Customer(String customerCode, int money) { 
		teller = new Teller();
		this.money = money;
		this.customerCode = customerCode;
		teller.bank.safe.put(customerCode, money);
	}
	
	/**
	 * 출금
	 * @param value 출금액
	 * @return 출금 성공 여부
	 */
	public boolean withdrawal(int value) {
		int deposit = teller.bank.safe.get(customerCode);
		boolean result;
		if(deposit - value >= 0) {
			money += value;
			teller.bank.safe.remove(customerCode);
			teller.bank.safe.put(customerCode, deposit - value);
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	/**
	 * 입금
	 * @param value 입금액
	 * @return 입금 성공 여부
	 */
	public boolean deposit(int value) {
		int deposit = teller.bank.safe.get(customerCode);
		boolean result;
		if(money - value >= 0) {
			money -= value;
			teller.bank.safe.remove(customerCode);
			teller.bank.safe.put(customerCode, deposit + value);
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Customer [customerCode=" + customerCode + ", money=" + money
				+ ", teller=" + teller + "]";
	}
	
	
}
