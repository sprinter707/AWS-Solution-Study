package solution6.bread;

import java.util.ArrayList;

public class IntegerTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] triangle= {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		IntegerTriangle temp = new IntegerTriangle();
		System.out.println(temp.solution(triangle));
	}
	public int solution(int[][] triangle) {
		int answer = 0;
        int depth = triangle.length;
        int lastLen = triangle[depth-1].length;
        
        int[][] array = new int[depth][lastLen];
        
        array[0][0] = triangle[0][0];
        
        for(int i=0; i<depth-1; i++) {
            int len = triangle[i].length;
            for(int j=0 ;j<len ; j++) {
                int curr = array[i][j];
                int height = i+1;
                
                if(array[height][j] < (curr + triangle[height][j])) {
                    array[height][j] = curr + triangle[height][j];
                }
                if(array[height][j+1] < (curr + triangle[height][j+1])) {
                    array[height][j+1] = curr + triangle[height][j+1];
                }
            }
        }
        
        for(int i=0; i<lastLen; i++ ) {
            if(answer < array[depth-1][i]) {
                answer = array[depth-1][i];
            }
        }
        
        
        
        return answer;
    }
}
