package solution.demeter;

/**
 * â�������� ���࿡ ������ �� �ִ�.
 * @author Administrator
 *
 */
public class Teller {

	//â�������� ���� ������ ��� ������ ������ �� �ִ�.
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
