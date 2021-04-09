package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution();
	}

	public static String solution() {
		int[] numbers = { 3, 30, 34, 5, 9, 12, 10, 23 };
		String answer = "";
		String[] tempArray = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			tempArray[i] = Integer.toString(numbers[i]);
		}
		Arrays.sort(tempArray, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		
		if(tempArray[0].equals("0")) {
			return "0";
		}
		StringBuilder buff = new StringBuilder();
		Arrays.stream(tempArray).forEach(x->buff.append(x));
		answer = buff.toString();
		return answer;
	}

}
