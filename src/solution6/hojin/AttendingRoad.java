package algorithm;

import java.util.HashMap;

public class AttendingRoad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AttendingRoad temp = new AttendingRoad();
		System.out.println(temp.solution());
	}

	class PointRoad {
		int x;
		int y;
		int wayOfNum;

		PointRoad(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void setWayOfNum(int wayOfNum) {
			this.wayOfNum = wayOfNum;
		}

		int getWayOfNum() {
			return this.wayOfNum;
		}
	}

	public int solution() {
		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 } };
		int answer = 0;

		int[][] wayOfAttend = new int[n][m];
		wayOfAttend[0][0] = 1;
		for (int k = 0; k < puddles.length; k++) {
			wayOfAttend[puddles[k][1] - 1][puddles[k][0] - 1] = -1;
		}
		
		for (int i = 1; i < m; i++) {
			if(wayOfAttend[0][i] == -1) {
				wayOfAttend[0][i] = 0;
			} else {
				wayOfAttend[0][i] = wayOfAttend[0][i-1] % 1000000007;
			}
		}
		for (int j = 1; j < n; j++) {
			if(wayOfAttend[j][0] == -1) {
				wayOfAttend[j][0] = 0;
			}else {
				wayOfAttend[j][0] = wayOfAttend[j-1][0] % 1000000007;
			}
		}

		

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if(wayOfAttend[j][i] == -1) {
					wayOfAttend[j][i] = 0 % 1000000007;
				}else {
					wayOfAttend[j][i] = wayOfAttend[j - 1][i] % 1000000007  + wayOfAttend[j][i - 1] % 1000000007 ;
				}
			}
		}
		answer = wayOfAttend[n - 1][m - 1] % 1000000007;

		return answer;
	}
}
