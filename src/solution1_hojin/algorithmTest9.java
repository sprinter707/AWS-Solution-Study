package algorithm;

import java.util.LinkedList;

public class algorithmTest9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution();
	}

	
	//프린터 - 스택/큐
	public static int solution() {
		class Printer {
			int location;
			int priority;

			Printer(int location, int priority) {
				this.location = location;
				this.priority = priority;
			}
		}
		
		int[] priorities = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int location = 0;
		int answer = 0;
		LinkedList<Printer> seqPrinter = new LinkedList<Printer>();

		for (int i = 0; i < priorities.length; i++) {
			seqPrinter.add(new Printer(i, priorities[i]));
		}
		
		while(seqPrinter.iterator().hasNext()) {
			boolean criteria = false;
			int comPrinter = seqPrinter.peek().priority;
			for(Printer p : seqPrinter) {
				if(comPrinter < p.priority) {
					criteria = true;
				}
			}
			
			if(criteria) {
				seqPrinter.add(seqPrinter.poll());
			} else {
				if(seqPrinter.poll().location == location) {
					answer = priorities.length - seqPrinter.size();
				}
			}
			
			
		}
		return answer;
	}

}
