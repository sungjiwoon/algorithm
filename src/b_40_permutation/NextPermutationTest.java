package b_40_permutation;
import java.util.Arrays;

public class NextPermutationTest {
	static int n = 4;
	private boolean next_permutation(int[] arr) {
		int idx = n-1;
		//�־��� ������ �ں��� Ž���Ͽ�, �����ϴ� �κ��� ã�´�. 
		while (idx > 0 && arr[idx -1] > arr[idx]) {
			idx--;
		}
		
		//�����ϴ� �κ��� ���ٸ� false ��ȯ. 
		if (idx == 0) {
			return false;
		}
		
		//�ش� �ε��� �������� �¿�� ������. 
		// ������ ���� ������ ���ڿ� ���Ͽ� ������ ���� ������ �������� Ž���Ͽ� ���� ū ���� ã�´�. 
		int big_idx = n-1;
		while (big_idx > idx && arr[idx-1] > arr[big_idx]) {
			big_idx--;
		}
		
		//�ش� ���ڸ� ã�Ҵٸ� �ٲ۴�. 
		int tmp = arr[idx-1];
		arr[idx-1] = arr[big_idx];
		arr[big_idx] = tmp;
		
		Arrays.sort(arr, idx, n);
		System.out.println(Arrays.toString(arr));
		return true;
		
	}
	public void work() {
		int[] arr = {1,2,3,4};
		while (next_permutation(arr));
		
	}
}
