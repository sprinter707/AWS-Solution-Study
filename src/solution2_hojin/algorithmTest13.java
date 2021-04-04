package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class algorithmTest13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = solution();
	}
	//이중우선순위큐 - 힙
	public static int[] solution() {
		String[] operations = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
		int[] answer = new int[2];
		LinkedList<Integer> priorityQueueStructure = new LinkedList<Integer>();

		for (int i = 0; i < operations.length; i++) {
			if (operations[i].startsWith("I")) {
				priorityQueueStructure.add(Integer.parseInt(operations[i].substring(2, operations[i].length())));
			} else {
				if (operations[i].substring(2, 3).equals("-")) {
					Collections.sort(priorityQueueStructure);
					priorityQueueStructure.poll();
				} else {
					Collections.reverse(priorityQueueStructure);
					priorityQueueStructure.poll();
					Collections.sort(priorityQueueStructure);
				}
			}
		}
		
		if (priorityQueueStructure.size() >= 2) {
			answer[0] = Collections.max(priorityQueueStructure);
			answer[1] = Collections.min(priorityQueueStructure);
		} else if (priorityQueueStructure.size() == 1) {
			if (priorityQueueStructure.peek() >= 0) {
				answer[0] = priorityQueueStructure.poll();
			} else {
				answer[1] = priorityQueueStructure.poll();
			}
		} else {
			// do nothing;
		}
		return answer;

	}

}
