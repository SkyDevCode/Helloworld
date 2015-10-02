import java.util.Arrays;
import java.util.List;


/**
 * asList()를 활용한 배열을 리스트로 복사
 * @author Administrator
 *
 */
public class UseArraysAsListExample {
	
	public static void main(String[] args) {
		Integer[] array = new Integer[100000];
		
		// 데이터 입력
		for(int i=0; i < 100000; i++) {
			array[i] = i;
		}
		
		// 시작 시간 
		long startTime = System.currentTimeMillis();
		
		List<Integer> list = (List<Integer>) Arrays.asList(array);
		
		//System.out.println(list); 
		
		// 종료시간
		long endTime = System.currentTimeMillis();
		
		// 시간 출력
		System.out.println("##실행시간(초.0f) : " + ( endTime - startTime )/1000.0f + " 초");
	}
}
