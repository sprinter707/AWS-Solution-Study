package solution5.bread;

import algorithm.CheckingCamera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ConnectingIsland {

	public int solution(int n, int[][] costs) {
		int answer =0;

		// 연결 테이블 초기화
		int[] cycleTable = new int[n];

		for(int i=0; i<n; i++) {
			cycleTable[i] = i;
		}

		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for(int i=0; i<costs.length; i++){
			if(isComplete(cycleTable)) {
				break;
			}

			int[] current = costs[i];
			int one = current[0];
			int other = current[1];
			int cost = current[2];

			if(cycleTable[other] != cycleTable[one]){

				int cycleTheOther = cycleTable[other];
				int cycleOne = cycleTable[one];



				// 다리 건설 표시
				for(int j=0; j<cycleTable.length; j++){
					// 더 작은 쪽으로 합친다.(Union-Find 알고리즘)
					if(cycleTable[j] == cycleTheOther && cycleOne<=cycleTheOther) {
						cycleTable[j] = cycleOne;
					} else if(cycleTable[j] == cycleOne && cycleTheOther<=cycleOne) {
						cycleTable[j] = cycleTheOther;
					}

				}
				// 다리 건설 비용용
				answer+=cost;
			}

		}

		return answer;
	}

	public boolean isComplete(int[] cycleTable){
		for(int i=1; i<cycleTable.length; i++) {
			if(cycleTable[i-1] != cycleTable[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		int n0 = 4; int[][] costs0 = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } }; // 4
		int n1 = 5; int[][] costs1 = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}; //15
		int n2 = 5; int[][] costs2 = {{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}}; //8
		int n3 = 4; int[][] costs3 =  {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {1, 3, 2}, {0, 3, 4}}; //9
		int n4 = 5; int[][] costs4 =  {{0, 1, 1}, {3, 1, 1}, {0, 2, 2}, {0, 3, 2}, {0, 4, 100}}; //104
		int n5 = 6; int[][] costs5 =  {{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}}; //11
		int n6 = 5; int[][] costs6 =  {{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100}}; //6
		int n7 = 5; int[][] costs7 =  {{0, 1, 1}, {0, 4, 5}, {2, 4, 1}, {2, 3, 1}, {3, 4, 1}}; //8
		int n8 = 5; int[][] costs8 =  {{0, 1, 1}, {0, 2, 2}, {0, 3, 3}, {0, 4, 4}, {1, 3, 1}}; //8

		ConnectingIsland tn = new ConnectingIsland();
		int answer0 = tn.solution(n0, costs0);
		int answer1 = tn.solution(n1, costs1);
		int answer2 = tn.solution(n2, costs2);
		int answer3 = tn.solution(n3, costs3);
		int answer4 = tn.solution(n4, costs4);
		int answer5 = tn.solution(n5, costs5);
		int answer6 = tn.solution(n6, costs6);
		int answer7 = tn.solution(n7, costs7);
		int answer8 = tn.solution(n8, costs8);

		System.out.println("4 : " + answer0 + " \t\t" + (answer0==4));
		System.out.println("15 : " + answer1 + " \t\t" + (answer1==15));
		System.out.println("8 : " + answer2 + " \t\t" + (answer2==8));
		System.out.println("9 : " + answer3 + " \t\t" + (answer3==9));
		System.out.println("104 : " + answer4 + " \t\t" + (answer4==104));
		System.out.println("11 : " + answer5 + " \t\t" + (answer5==11));
		System.out.println("6 : " + answer6 + " \t\t" + (answer6==6));
		System.out.println("8 : " + answer7 + " \t\t" + (answer7==8));
		System.out.println("8 : " + answer8 + " \t\t"	 + (answer8==8));

	}

}
