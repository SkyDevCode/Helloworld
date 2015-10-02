import java.util.Arrays;

/**
 * arraycopy를 활용한 배열복사
 * arraycopy 사용법
 * arraycopy ([원본 배열], [복사 시작 위치], [대상 배열], [대상 배열의 시작 위치], [복사 길이])
 * @author Administrator
 *
 */
public class AvoidArrayLoopsExample {
	
	public static void main(String[] args) {
		
		int[] source = new int[100000];
		
		// 원본 배열에 값 입력
		for(int i = 0; i < source.length; i++) {
			source[i] = i;
		}
		
		AvoidArrayLoopsExample example = new AvoidArrayLoopsExample();
		example.copyByArrayCopy(source);
	}
	
	
	public int[] copyByArrayCopy(int[] source) {
		int[] target = new int[source.length];
		
		long startTime = System.currentTimeMillis();
		
		System.arraycopy(source, 0, target, 0, source.length);
		
		//System.out.println(Arrays.toString(target));
		
		long endTime = System.currentTimeMillis();
		
		//실행 시간 출력
		System.out.println("##arraycopy 실행시간(초.0f) : " + (endTime - startTime )/1000.0f +" 초");
		
		return target;
	}
}
