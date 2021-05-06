package solution6.bread;


import java.util.ArrayList;

import java.util.HashMap;

public class AttendingRoad {
    public int NN =  1000000007;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 } };

		AttendingRoad temp = new AttendingRoad();
		System.out.println(temp.solution(m, n, puddles));
	}

	public int solution(int m, int n, int[][] puddles) {
		int answer = 0;
        
        int[][] route = new int[m][n];
        int[][] floodMap = new int[m][n];
        
        for(int[] puddle : puddles) {
            floodMap[puddle[0]-1][puddle[1]-1] = -1;
        }

        route[0][0] = 1;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j!=0) {
                    if(floodMap[i][j] != -1) {
                        route[i][j] = route[i][j-1];
                    }
                } else if(i!=0 && j==0) {
                    if(floodMap[i][j] != -1) {
                        route[i][j] = route[i-1][j];
                    }
                } else if(i!=0 && j!=0) {
                    if(floodMap[i][j] == -1) {
                        route[i][j] = 0;
                    } else {
                        route[i][j] = (route[i-1][j] + route[i][j-1])%NN;
                    }
                }
                
            }
        }
        
        answer = route[m-1][n-1];
        
        return answer;
	}
}
