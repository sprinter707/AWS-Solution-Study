package algorithm;

import java.util.ArrayList;

public class IntegerTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerTriangle temp = new IntegerTriangle();
		System.out.println(temp.solution());
	}
	public int solution() {
		int answer = 0;
		int[][] triangle= {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		ArrayList<ArrayList<Integer>> answerList = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0 ; i < triangle.length ; i++ ) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0 ; j <= i ; j++) {
				if(i > 0) {
					if(j == 0) {
						temp.add(j,answerList.get(i-1).get(j) + triangle[i][j]);
					} else if ( j == i) {
						temp.add(j,answerList.get(i-1).get(j-1) + triangle[i][j]);
					} else {
						int maxTempInt = Math.max(answerList.get(i-1).get(j-1) + triangle[i][j], answerList.get(i-1).get(j) + triangle[i][j]);
						temp.add(j,maxTempInt);
					}
				} else {
					temp.add(triangle[i][j]);
				}
			}
			answerList.add(i,temp);
		}
		
		for(Integer tempIntLastLine : answerList.get(triangle.length-1)) {
			if(tempIntLastLine > answer) {
				answer = tempIntLastLine;
			}
		}
		
        return answer;
    }
}
