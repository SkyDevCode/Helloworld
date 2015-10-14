package chap02;

/**
 * 
 * main() 메서드를 통해 스프링과 Greeter를 실행하는 자바 클래스
 * @author 
 */
public class Main {
	
	public static void main(String args[]) {
		Greeter greeter = new Greeter();
		greeter.setFormat("%s, 안녕하세요!");
		String msg = greeter.greet("스프링"); // msg에는 "스프링, 안녕하세요!"라는 문자열이 저장된다.
		System.out.println("출력결과: "+msg);
	}
}
