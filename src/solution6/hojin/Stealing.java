package algorithm;

public class Stealing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stealing temp = new Stealing();
		System.out.println(temp.solution());
	}

	public int solution() {
		int answer = 0;
		int answerEven = 0;
		int answerOdd = 0;
		int answerFirst = 0;
		int answerSecond = 0;
		int[] money = {90, 0, 0, 95, 1, 1};
		answerEven += money[0];
		answerOdd += money[1];

		for (int i = 2; i < money.length-1; i++) {
			if (i % 2 == 0) {
				answerOdd = Math.max(answerOdd, answerEven);
				answerEven = Math.max(answerOdd, answerEven + money[i]);
			} else {
				answerEven = Math.max(answerOdd, answerEven);
				answerOdd = Math.max(answerEven, answerOdd + money[i]);
			}
		}
		
		answerFirst = Math.max(answerEven, answerOdd);

		answerEven = 0;
		answerOdd = 0;
		answerOdd += money[1];
		answerEven += money[2];

		for (int i = 3; i < money.length; i++) {
			if (i % 2 == 0) {
				answerOdd = Math.max(answerOdd, answerEven);
				answerEven = Math.max(answerOdd, answerEven + money[i]);
			} else {
				answerEven = Math.max(answerOdd, answerEven);
				answerOdd = Math.max(answerEven, answerOdd + money[i]);
			}
		}
		
		answerSecond = Math.max(answerEven, answerOdd);
		
		
		answer = Math.max(answerFirst,answerSecond);
		
		
		return answer;
	}
}
