package solution.demeter;

public class LoosingCouplingExample {
	public static void main(String[] args) {
		Customer ted = new Customer("C01", 1000);
		Customer yuto = new Customer("C01", 1000);
		
		ted.deposit(100); //입금
		ted.withdrawal(90); //출금
		
		System.out.println("ted money:"+ted.getBalance());
		System.out.println("yuto money:"+yuto.getBalance());
	}
}
