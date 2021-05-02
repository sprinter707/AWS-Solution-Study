package solution6.bread;

import java.util.ArrayList;
import java.util.HashMap;
// N
// NN = N*10 + N
// N+N
// N-N
// N*N
// N/N

// NNN
// N + N + N
// N + N - N
// (N + N)*10 + N
// (N - N)*10 + N
// (N * N)*10 + N
// (N / N)*10 + N
// (N*10 + N)*10 + N

public class ExpressionN {
	private HashMap<Integer, ArrayList<Integer>> h;
	private int NUM;

	public boolean calc(int N, int count) {
		ArrayList<Integer> list = h.get(count-1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();

		for(int n : list) {
			// NN
			list2.add(n*10 + N);
			// N+N
			list2.add(n+N);
			// N-N
			if(n-N > 0) list2.add(n-N);
			// N/N
			if(n/N > 0) list2.add(n/N);
			// N*N
			list2.add(n*N);
		}

		for(int j=2; j<count ; j++) {
			ArrayList<Integer> x = h.get(j);
			ArrayList<Integer> y = h.get(count-j);

			for(int x1: x) {
				for(int y1: y) {
					list2.add(x1 + y1);
					if(x1-y1>0) { list2.add(x1-y1); }
					if(x1/y1>0) { list2.add(x1 / y1); }
				}
			}
		}

		h.put(count, list2);

		if(list2.contains(NUM)) {
			return true;
		} else{
			return false;
		}
	}

	public int solution(int N, int number) {
		int answer = -1;
		NUM = number;

		ArrayList<Integer> temp = new ArrayList<Integer>();
		h = new HashMap<Integer, ArrayList<Integer>>();

		temp.add(N);
		h.put(1, temp);

		if(number == N ) {
			return 1;
		}

		for(int i=1; i<=8 ;i++) {
			if(calc(N, i)) {
				answer = i;
				break;
			}
		}

		return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionN temp = new ExpressionN();
		int N = 5;
		int number = 12;

		int N2 = 5; int number2 = 5; //1
		System.out.println(temp.solution(N2, number2));
	}
}
