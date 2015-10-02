package problem.coupling;

/**
 * ������ ������ϴ� ��
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
	 * ���
	 * @param value ��ݾ�
	 * @return ��� ���� ����
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
	 * �Ա�
	 * @param value �Աݾ�
	 * @return �Ա� ���� ����
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
