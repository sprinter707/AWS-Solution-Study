package algorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class algorithmTest5 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	//다리를 지나는 트럭 - 스택/큐
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		//2	10	[7,4,5,6]
		int answer = 0;
        LinkedList<Integer> qu = new LinkedList<Integer>();
        int[] time = new int[truck_weights.length];
        int truckCount = 0;
        while(true) {
        	if(truckCount == truck_weights.length && qu.size() == 0 ) {
        		break;
        	}
        	if(truckCount < truck_weights.length) {
        		int totalWeight = 0;
            	qu.offer(truck_weights[truckCount++]);
            	
            	Iterator<Integer> ite = qu.iterator();
            	while(ite.hasNext()) {
            		totalWeight+=ite.next();
            	}
            	if(totalWeight>weight) {
            		qu.pollLast();
            		truckCount--;
            	}
        	}
        	for(int j=0 ; j < truckCount; j++ ) {
                time[j]++;
        		if(time[j] == bridge_length) {
        			qu.poll();
        			System.out.println("qu polling!");
        		}
        		
        	}
        	answer++;
        }
        
        return answer+1;
    }
	
}
