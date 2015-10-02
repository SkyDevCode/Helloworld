import java.util.Arrays;

/**
 * arraycopy�� Ȱ���� �迭����
 * arraycopy ����
 * arraycopy ([���� �迭], [���� ���� ��ġ], [��� �迭], [��� �迭�� ���� ��ġ], [���� ����])
 * @author Administrator
 *
 */
public class AvoidArrayLoopsExample {
	
	public static void main(String[] args) {
		
		int[] source = new int[100000];
		
		// ���� �迭�� �� �Է�
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
		
		//���� �ð� ���
		System.out.println("##arraycopy ����ð�(��.0f) : " + (endTime - startTime )/1000.0f +" ��");
		
		return target;
	}
}
