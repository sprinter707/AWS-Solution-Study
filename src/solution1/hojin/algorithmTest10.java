package algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class algorithmTest10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution();
	}
	//기능개발 - 스택/큐
	public static int[] solution() {
		int[] progresses = new int[] { 95, 90, 99, 99, 80, 99 };
		int[] speeds = new int[] { 1, 1, 1, 1, 1, 1 };
		LinkedList<Integer> days = new LinkedList<Integer>();
		LinkedList<Integer> answers = new LinkedList<Integer>();
		int[] answer = {};

		for (int i = 0; i < progresses.length; i++) {
			days.offer((int) Math.ceil((100 - progresses[i]) / (double) speeds[i]));
		}

		while (days.iterator().hasNext()) {
			int comInt = days.poll();
			int numOfDeploy = 1;
			int sizeOfdays = days.size();
			for (int j = 0; j < sizeOfdays; j++) {
				if (comInt >= days.get(j)) {
					numOfDeploy++;
				}else {
					break;
				}
			}
			answers.add(numOfDeploy);
			while(numOfDeploy>1) {
				days.poll();
				numOfDeploy--;
			}
		}

		answer = answers.stream().mapToInt(x -> x).toArray();

		return answer;
	}

}
