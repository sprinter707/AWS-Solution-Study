package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FindingPrimeNum {
	private static TreeSet<String> set = new TreeSet<String>();
	private static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindingPrimeNum temp = new FindingPrimeNum();
		temp.solution();

	}

	public int solution() {
		int answer = 0;
		String numbers = "011";
		ArrayList<String> numList = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < numbers.length(); i++) {
			numList.add(numbers.substring(i, i+1));
		}
		
		for (int i = 0; i < numbers.length(); i++) {
			permutation(numList, result, numbers.length(), i + 1);
		}

		return answer;
	}

	public static boolean findingPrime(int number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void permutation(List<String> arr, List<String> result, int n, int r) {

		if (r == 0) {
			// 0���� �����ϴ� �κ������� ����
			if (!result.get(0).equals("0")) {
				String str = "";
				int size = result.size();
				for (int i = 0; i < size; i++) {
					str += result.get(i);
				}
				
				// �̹� ���� ���� ������ �ƴ� ���
				if (!set.contains(str)) {
					int num = Integer.parseInt(str);
					set.add(str);

					// �Ҽ� �Ǻ�
					if (findingPrime(num)) {
						System.out.println(num);
						count++;
					}
				}
			}

			return;
		}
		for (int i = 0; i < n; i++) {
			result.add(arr.remove(i));
			permutation(arr, result, n - 1, r - 1);
			arr.add(i, result.remove(result.size() - 1));
		}

	}
	
}
