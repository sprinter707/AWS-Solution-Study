package algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class algorithmTest12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = solution();
	}
	//디스크 컨트롤러 - 힙
	public static int solution() {
		int[][] jobs = { {0,3},{1,9},{2,6} };
		int totalSize = jobs.length;
		int answer = 0;
        int time = 0;
        PriorityQueue<Integer> toBeActivatedQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> toBeDeletedQueue = new PriorityQueue<Integer>();
        
        
        while(jobs.length>0) {
        	for(int[] job : jobs) {
        		if(time>=job[0]) {
        			toBeActivatedQueue.add(job[1]);
        		}
	        }
        	if(toBeActivatedQueue.size()>=1) {      		
        		int wastedTime = toBeActivatedQueue.poll();
        		for(int[] job : jobs) {
            		if(wastedTime ==job[1]) {
            			toBeDeletedQueue.add(job[0]);
            		}
    	        }
        		int startTime = toBeDeletedQueue.poll();
        		int[][] newJobsArray = new int[jobs.length-1][2];
        		int i = 0;
        		for(int[] job : jobs) {
            		if(wastedTime ==job[1] && startTime ==job[0] ) {
            			continue;
            		}
            		newJobsArray[i++] = job;
    	        }
        		jobs = newJobsArray;
        		answer += (time - startTime + wastedTime);
        		time += wastedTime;
        		toBeActivatedQueue.clear();
        		toBeDeletedQueue.clear();
        	}else {
        		time++;
        	}
        	
        }
		
		return answer/totalSize;

	}

}
