package algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class GiveUpMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GiveUpMath temp = new GiveUpMath();
		temp.solution();
	}

	public int[] solution() {
		int[] answer = { 1, 2, 3, 4, 5 };
		LinkedList<Integer> returnAnswer = new LinkedList<Integer>();
		returnAnswer.add(1);
		returnAnswer.add(2);
		returnAnswer.add(3);
		int[] supoja1 = { 1, 2, 3, 4, 5 };
		int[] supoja2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] supoja3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int numOfAns1 = 0;
		int numOfAns2 = 0;
		int numOfAns3 = 0;
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == supoja1[i % 5]) {
				numOfAns1++;
			}
			if (answer[i] == supoja2[i % 8]) {
				numOfAns2++;
			}
			if (answer[i] == supoja3[i % 10]) {
				numOfAns3++;
			}
		}
		if (numOfAns1 == numOfAns2 && numOfAns2 == numOfAns3) {
			// do nothing
		} else if (numOfAns1 == numOfAns2 && numOfAns2 > numOfAns3) {
			returnAnswer.remove(2);
		} else if (numOfAns2 == numOfAns3 && numOfAns2 > numOfAns1) {
			returnAnswer.remove(0);
		} else if (numOfAns1 == numOfAns3 && numOfAns1 > numOfAns2) {
			returnAnswer.remove(1);
		} else {
			if (numOfAns1 == Math.max(numOfAns1, Math.max(numOfAns2, numOfAns3))) {
				returnAnswer.pollLast();
				returnAnswer.pollLast();
			} 
			else if (numOfAns2 == Math.max(numOfAns1, Math.max(numOfAns2, numOfAns3))) {
				returnAnswer.pollLast();
				returnAnswer.pollFirst();
			} 
			else {
				returnAnswer.poll();
				returnAnswer.poll();
			}
		}

		returnAnswer.stream().forEach(x -> System.out.println(x));

		return returnAnswer.stream().mapToInt(x -> x).toArray();
	}

}
