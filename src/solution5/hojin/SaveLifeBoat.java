package algorithm;

import java.util.Arrays;

public class SaveLifeBoat {
	public int solution() {

		// Âü°í¿ë
		/*
		 * ArrayList<Integer> temp = new ArrayList<Integer>(); Collections.sort(temp,
		 * new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { return
		 * o1.compareTo(o2); } } Integer[] temp2 = Arrays.stream( people
		 * ).boxed().toArray( Integer[]::new );
		 * Arrays.sort(temp2,Collections.reverseOrder());
		 */
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		int answer = 0;
		int max = people.length-1;
		int min = 0; 
		Arrays.sort(people);
		Arrays.stream(people).forEach(x->System.out.println(x));
		
		for(int i = max ; min <= i ; i-- ) {
			if(people[i] + people[min] <= limit) {
				min++;
			}
			answer++;
		}
		System.out.println(answer);
		
		return answer;

	}

	public static void main(String[] args) {
		SaveLifeBoat tn = new SaveLifeBoat();
		tn.solution();

	}

}
