package problem.coupling;

public class LoosingCouplingExample {
	
	public static void main(String[] args) {
		Customer ted = new Customer("C01", 1000);
		Customer yuto = new Customer("C01", 1000);
		
		ted.deposit(100);
		ted.withdrawal(90);
		
		System.out.println(ted);
		System.out.println(yuto);
	}
}
