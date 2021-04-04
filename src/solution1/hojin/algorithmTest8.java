package algorithm;

import java.util.LinkedList;
import java.util.stream.Stream;

public class algorithmTest8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution();
	}
	//주식가격 - 스택/큐
	public static int[] solution() {
		int[] prices = { 1, 2, 3, 2, 3 };
		int[] answer = new int[prices.length];
		LinkedList<Integer> temp = new LinkedList<Integer>();

		for (Integer tempInt : prices) {
			temp.add(tempInt);
		}

		for (int j = 0; j < prices.length; j++) {
			int compareInt = temp.pop();
			for (int i = 0; i < temp.size(); i++) {
				if (compareInt <= temp.get(i)) {
					answer[j]++;
				} else {
					answer[j]++;
					break;
				}
			}
		}
		
//		for (int j = 0; j < prices.length; j++) {
//			for (int i = j+1; i < prices.length; i++) {
//				if (prices[j] <= prices[i]) {
//					answer[j]++;
//				} else {
//					answer[j]++;
//					break;
//				}
//			}
//		}
//		
//		for(int k = 0 ; k < answer.length ; k ++) { 
//			System.out.println(answer[k]);
//		}
		
		return answer;
	}

}
