package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class JoyStick {
	public int solution() {
		String name = "ABABAAAAABA";
		int answer = 0;
		int rightWayAns = 0;
		int leftWayAns = 0;
		int lengthOfName = name.length();
		int initial = "A".charAt(0);
		int center = "N".charAt(0);
		int last = "Z".charAt(0);

		ArrayList<Integer> tempSaver = new ArrayList<Integer>();
		for (int i = 1; i < lengthOfName; i++) {
			if (initial != name.charAt(i)) {
				tempSaver.add(i);
			}
		}

		if (name.charAt(0) > center) {
			answer += last - name.charAt(0) + 1;
		} else {
			answer += name.charAt(0) - initial;
		}

		int pos = 0;
		while (tempSaver.size() > 0) {
			int criteriaIndex = 0;
			int maxRoute = 20;
			for (int i = 0; i < tempSaver.size(); i++) {
				if (Math.min(Math.abs(pos - tempSaver.get(i)), Math.min(pos + lengthOfName - tempSaver.get(i),
						lengthOfName - pos + tempSaver.get(i))) < maxRoute) {
					maxRoute = Math.min(Math.abs(pos - tempSaver.get(i)), Math.min(pos + lengthOfName - tempSaver.get(i),
							lengthOfName - pos + tempSaver.get(i)));
					criteriaIndex = i;
				}
			}
			
			answer += maxRoute;
			if (name.charAt(tempSaver.get(criteriaIndex)) > center) {
				answer += last - name.charAt(tempSaver.get(criteriaIndex)) + 1;
			} else {
				answer += name.charAt(tempSaver.get(criteriaIndex)) - initial;
			}
			pos = tempSaver.get(criteriaIndex);
			tempSaver.remove(tempSaver.get(criteriaIndex));
		}
		
		return answer;

	}

	public static void main(String[] args) {
		JoyStick tn = new JoyStick();
		tn.solution();

	}

}
