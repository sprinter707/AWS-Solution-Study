package algorithm;

import java.util.ArrayList;

public class ExpressionN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionN temp = new ExpressionN();
		System.out.println(temp.solution());
	}
	public int solution() {
		int N = 5;
		String NtoString = String.valueOf(N);
		int number = 12;
		int answer = -1;
		ArrayList<ArrayList<Integer>> answerList = new ArrayList<ArrayList<Integer>>();
		answerList.add(0,null);
		for(int i = 1 ; i <= 8 ; i++ ) {
			if(i>=2) {
				String connectionStringN = "";
				
				for(int j = 1; j <= i ; j ++) {
					connectionStringN += NtoString;
				}
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(Integer.parseInt(connectionStringN));
				answerList.add(i, temp);
				
				for(int j = 1; j < i ; j++ ) {
					int sizeOfArrayListOnJ = answerList.get(j).size();
					for(int k = 0 ; k < sizeOfArrayListOnJ ; k++ ) {
						int sizeOfArrayListOnIJ = answerList.get(i-j).size();
						for(int m = 0 ; m < sizeOfArrayListOnIJ; m++ ) {
							answerList.get(i).add(answerList.get(j).get(k) + answerList.get(i-j).get(m));
							answerList.get(i).add(answerList.get(j).get(k) - answerList.get(i-j).get(m));
							answerList.get(i).add(answerList.get(j).get(k) * answerList.get(i-j).get(m));
							if(answerList.get(i-j).get(m) != 0) {
								answerList.get(i).add(answerList.get(j).get(k) / answerList.get(i-j).get(m));
							}
						}
					}
				}
				
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(N);
				answerList.add(i, temp);
			}
			for(Integer temp : answerList.get(i)) {
				if(temp == number) {
					return i;
				}
			}
		}
		
        return answer;
    }
}
