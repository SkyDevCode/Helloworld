import java.util.Arrays;
import java.util.List;


/**
 * asList()�� Ȱ���� �迭�� ����Ʈ�� ����
 * @author Administrator
 *
 */
public class UseArraysAsListExample {
	
	public static void main(String[] args) {
		Integer[] array = new Integer[100000];
		
		// ������ �Է�
		for(int i=0; i < 100000; i++) {
			array[i] = i;
		}
		
		// ���� �ð� 
		long startTime = System.currentTimeMillis();
		
		List<Integer> list = (List<Integer>) Arrays.asList(array);
		
		//System.out.println(list); 
		
		// ����ð�
		long endTime = System.currentTimeMillis();
		
		// �ð� ���
		System.out.println("##����ð�(��.0f) : " + ( endTime - startTime )/1000.0f + " ��");
	}
}
