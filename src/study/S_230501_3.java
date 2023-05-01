package study;

import java.io.IOException;
import java.util.Arrays;
/*
 * ���� ����
1���� n���� ��ȣ�� �پ��ִ� n���� ����� ���� �����ձ⸦ �ϰ� �ֽ��ϴ�. ���� �����ձ�� ������ ���� ��Ģ���� ����˴ϴ�.

1������ ��ȣ ������� �� ����� ���ʴ�� �ܾ ���մϴ�.
������ ����� �ܾ ���� �������� �ٽ� 1������ �����մϴ�.
�ջ���� ���� �ܾ��� ������ ���ڷ� �����ϴ� �ܾ ���ؾ� �մϴ�.
������ �����ߴ� �ܾ�� ����� �� �����ϴ�.
�� ������ �ܾ�� �������� �ʽ��ϴ�.
������ 3���� �����ձ⸦ �ϴ� ��Ȳ�� ��Ÿ���ϴ�.

tank �� kick �� know �� wheel �� land �� dream �� mother �� robot �� tank

�� �����ձ�� ������ ���� ����˴ϴ�.

1�� ����� �ڽ��� ù ��° ���ʿ� tank�� ���մϴ�.
2�� ����� �ڽ��� ù ��° ���ʿ� kick�� ���մϴ�.
3�� ����� �ڽ��� ù ��° ���ʿ� know�� ���մϴ�.
1�� ����� �ڽ��� �� ��° ���ʿ� wheel�� ���մϴ�.
(��� ����)
�����ձ⸦ ��� ������ ������ ����, 3�� ����� �ڽ��� �� ��° ���ʿ� ���� tank ��� �ܾ�� ������ �����ߴ� �ܾ��̹Ƿ� Ż���ϰ� �˴ϴ�.

����� �� n�� ������� ������� ���� �ܾ� words �� �Ű������� �־��� ��, ���� ���� Ż���ϴ� ����� ��ȣ�� �� ����� �ڽ��� �� ��° ���ʿ� Ż���ϴ����� ���ؼ� return �ϵ��� solution �Լ��� �ϼ����ּ���.

���� ����
�����ձ⿡ �����ϴ� ����� �� n�� 2 �̻� 10 ������ �ڿ����Դϴ�.
words�� �����ձ⿡ ����� �ܾ���� ������� ����ִ� �迭�̸�, ���̴� n �̻� 100 �����Դϴ�.
�ܾ��� ���̴� 2 �̻� 50 �����Դϴ�.
��� �ܾ�� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
�����ձ⿡ ���Ǵ� �ܾ��� ��(�ǹ�)�� �Ű� ���� �����ŵ� �˴ϴ�.
������ [ ��ȣ, ���� ] ���·� return ���ּ���.
���� �־��� �ܾ��� Ż���ڰ� ������ �ʴ´ٸ�, [0, 0]�� return ���ּ���.
����� ��
n	words	result
3	["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]	[3,3]
5	["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]	[0,0]
2	["hello", "one", "even", "never", "now", "world", "draw"]	[1,3]
����� �� ����
����� �� #1
3���� ����� �����ձ⿡ �����ϰ� �ֽ��ϴ�.

1�� ��� : tank, wheel, mother
2�� ��� : kick, land, robot
3�� ��� : know, dream, tank
�� ���� ������ ���� �ϰ� �Ǹ�, 3�� ����� �ڽ��� �� ��° ���ʿ� ���� tank��� �ܾ 1�� ����� �ڽ��� ù ��° ���ʿ� ���� tank�� �����Ƿ� 3�� ����� �ڽ��� �� ��° ���ʷ� ���� �� �� ó�� Ż���ڰ� ������ �˴ϴ�.
 */
public class S_230501_3 {
	private static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		String s = words[0];
		for (int i = 1; i < words.length; i++) {
			if (s.charAt(s.length()-1) != words[i].charAt(0)) {
				//System.out.println(i + " " + words[i]);
				answer[0] = i%n+1;
				answer[1] = i/n+1;
				return answer;
			} else {
				for (int j = 0; j < i; j++) {
					if (words[i].equals(words[j])) {
						//System.out.println(i + "," + j + " " + words[i] + " " + words[j]);
						answer[0] = i%n+1;
						answer[1] = i/n+1;
						return answer;
					}
				}
			}
			s = words[i];
		}
		answer[0] = 0;
		answer[1] = 0;
		return answer;
	}
	public void work() throws NumberFormatException, IOException {
		String[] st = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
	    System.out.println(Arrays.toString(solution(3, st)));
	}
}
