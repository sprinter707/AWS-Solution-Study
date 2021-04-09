package algorithm;

import java.util.Arrays;

public class NumOfKth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution();
	}
	
	public static int[] solution() {
		int[] array = { 1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] answer = new int[commands.length];
        
        for(int i = 0 ; i < commands.length; i++) {
        	int eachNum = rtnNmb(array,commands[i]);
        	answer[i] = eachNum;
        }
        
        return answer;
    }
	
	public static int rtnNmb(int[] tempArr, int[] commArr) {
		int[] tempInt = Arrays.copyOfRange(tempArr, commArr[0]-1, commArr[1]);
		Arrays.sort(tempInt);
		return Arrays.copyOfRange(tempInt,commArr[2]-1, commArr[2])[0];
	}
	
}
