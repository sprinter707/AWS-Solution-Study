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

	public boolean calc(int N, int count) {
		ArrayList<Integer> list = h.get(count-1);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        
        int temp =0;
        // NNNN
        for(int i=0; i<count; i++) {
            temp = temp*10 + N;
        }
        list2.add(temp);
        
        for(int j=1; j<count ; j++) {
            // count 4 일때, NNNN과 1+3 U 2+2 U 3+1 조합
            ArrayList<Integer> x = h.get(j);
            ArrayList<Integer> y = h.get(count-j); 
            
            for(int x1: x) {
                for(int y1: y) {
                    list2.add(x1 + y1);
                    list2.add(x1 * y1);
                    if(x1-y1>0) { list2.add(x1-y1); }
                    if(y1-x1>0) { list2.add(y1-x1); }
                    if(x1/y1>0) { list2.add(x1 / y1); }
                    if(y1/x1>0) { list2.add(y1 / x1); }
                }
            }
        }
        
        h.put(count, list2);
        
        if(list2.contains(number)) {
            return true;
        } else{
            return false;
        }
	}

	public int solution(int N, int number) {
		int answer = -1;
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        h = new HashMap<Integer, ArrayList<Integer>>();
        
        temp.add(N);
        h.put(1, temp);
        
        if(number == N ) {
			return 1;
		}
               
        for(int i=2; i<=8 ;i++) {
            if(calc(N, i, number)) {
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
