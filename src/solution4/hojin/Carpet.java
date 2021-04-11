package algorithm;

import java.util.ArrayList;

public class Carpet {

	public static void main(String[] args) {
		int[] temp = solution();
	}

	public static int[] solution() {
		int[] answer = new int[2];
		int brown = 10;
		int yellow = 2;
		int sumOfTiles = brown + yellow;
		ArrayList<Integer> temp = new ArrayList<Integer>();

		for (int i = 2; i <= Math.sqrt(sumOfTiles); i++) {
			if (sumOfTiles % i == 0) {
				temp.add(i);
				temp.add(sumOfTiles / i);
			}
		}

		for (int j = 0; j < temp.size()/2; j++) {
			if((temp.get(j*2)-2) * (temp.get(j*2+1)-2) == yellow && temp.get(j*2)-2 >0 && temp.get(j*2+1)-2 >0) {
				answer[0] = temp.get(j*2+1);
				answer[1] = temp.get(j*2);
			}
		}

		return answer;
	}

}
