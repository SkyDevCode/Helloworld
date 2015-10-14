package chap02;
/**
 * Greeter.java
 * 콘솔에 간단한 메시지를 출력하는 자바 클랙스
 * @author 
 *
 */
public class Greeter {

	private String format;
	
	/**
	 * 설정된 문자열 포맷 (format)을 이용해서 새로운 문자열을 
	 * @param guest
	 * @return
	 */
	public String greet(String guest) {
		return String.format(format,  guest);
	}
	
	/**
	 * @param format greet()메서드에서 사용할 문자열 포맷
	 */
	public void setFormat(String format) {
		this.format = format;
	}
}
