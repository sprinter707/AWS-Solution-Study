package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TargetNumber {
	static int answer = 0;
    public int solution() {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        ArrayList<Integer>[] temp = new ArrayList[numbers.length];
        int[] discovered = new int[numbers.length];
        
        for(int i = 0 ; i < numbers.length ; i++ ){
        	temp[i] = new ArrayList<Integer>();
            temp[i].add(1);
            temp[i].add(-1);
        }
        System.out.println(Integer.parseInt("001"));
        
        bfs(temp, 0, 0, target);
        System.out.println(answer);
        return answer;
        
    }
    
    public void bfs(ArrayList<Integer>[] temp, int node, int tempAnswer, int targetAnswer){
    	if(node==temp.length) {
    		if(tempAnswer == targetAnswer) {
    			answer++;
    		}
    		return;
    	} else {   	
    		for(Integer tempInt : temp[node]) {
    			bfs(temp,node+1,tempAnswer+tempInt,targetAnswer);
    		}
    	}
    }
	public static void main(String[] args) {
		TargetNumber tn = new TargetNumber();
		tn.solution();

	}

}
