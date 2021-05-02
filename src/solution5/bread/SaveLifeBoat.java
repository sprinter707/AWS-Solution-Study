package solution5.bread;

import java.util.Arrays;

public class SaveLifeBoat {
	public int solution(int[] people, int limit) {
		int answer = 0;

		int start = 0;
		int end = people.length-1;

		int weight = 0;

		Arrays.sort(people);

		while(start<=end) {
			if(people[start] + people[end] <= limit) {
				answer++;
				start++;
				end--;
			} else {
				answer++;
				end--;
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		int[] people1 = { 70, 50, 80, 50 };
		int[] people2 = { 70, 80, 50 };
		int limit = 100;
		SaveLifeBoat tn = new SaveLifeBoat();
		int answer = tn.solution(people1, limit);

		System.out.println(answer);

	}

}
