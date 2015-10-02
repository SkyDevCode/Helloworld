package solution.demeter;

/**
 * Customer ���� ���� â�������� ���ؼ��� �Աݰ� ����� �� �� �ִ�.
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
	 * ���
	 * @param value ���ݾ�
	 * @return ��� ���� ����
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
	 * �Ա�
	 * @param value �Աݾ�
	 * @return �Ա� ���� ����
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
