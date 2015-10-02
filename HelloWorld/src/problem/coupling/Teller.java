package problem.coupling;

/**
 * 고객의 요청을 받아들여 은행 업무를 처리하는 객체
 */
public class Teller {
	
	// 은행이 공개돼 있어 모든 객체에서 접근할 수 있다.
	public Bank bank;
	
	public Teller() {
		bank = new Bank();
	}

}
