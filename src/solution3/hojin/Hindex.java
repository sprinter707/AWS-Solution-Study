package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Hindex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution();
	}

	public static int solution() {
		int[] citations = { 3, 0, 6, 1, 5 };
		Integer[] tempCitations = new Integer[citations.length];
		int answer = 0;
		for (int i = 0; i < citations.length; i++) {
			tempCitations[i] = citations[i];
		}
		Arrays.sort(tempCitations, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		Arrays.stream(tempCitations).forEach(x -> System.out.println(x));
		for (int j = tempCitations[0] ; j >= 0; j--) {
			int count = 0;
			for (int k = 0; k < tempCitations.length; k++) {
				if(tempCitations[k]>=j) {
					count++;
				}
			}
			if(count>=j && tempCitations.length-count <=j) {
				answer = j;
				break;
			}
		}
		return answer;
	}
}
