package problem.coupling;

import java.util.HashMap;
import java.util.Map;

/**
 * ���� ������ �����ϴ� ���� ��ü
 * @author Administrator
 *
 */
public class Bank {

	// ���� �ݰ� ������ �־� ��𼭵� �������� ������ ����
	public Map<String, Integer> safe;
	
	public Bank() {
		safe = new HashMap<String, Integer>();
	}
}
