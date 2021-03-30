package solution2.bread;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DiscController {

    public static class Solution {
        public void print(int ans) {
            System.out.println("[" + ans + "]");
        }

        class Job {
            int reqTime;
            int workingTime;

            Job(int reqTime, int workingTime){
                this.reqTime = reqTime;
                this.workingTime = workingTime;
            }
        }

        public int solution(int[][] jobs) {
            int waitingTime = 0;
            int time = 0;
            int cnt=0;
            int len = jobs.length;

            PriorityQueue<Job> input = new PriorityQueue<>(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.reqTime - o2.reqTime;
                }
            });

            PriorityQueue<Job> waiting = new PriorityQueue<>(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.workingTime - o2.workingTime;
                }
            });

            for(int[] job : jobs) {
                input.offer(new Job(job[0], job[1]));
            }

            Job jb = input.peek();
            time = jb.reqTime;

            while(cnt < len) {
                while(!input.isEmpty() && input.peek().reqTime <= time) {
                    waiting.offer(input.poll());
                }

                if(!waiting.isEmpty()) {
                    jb = waiting.poll();
                    time += jb.workingTime;
                    waitingTime += time - jb.reqTime;
                    cnt++;
                } else {
                    time++;
                }
            }

            return waitingTime/len;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] jobs = {
                {0,3},
                {1,9},
                {2,6}
        };

        int ans = s.solution(jobs);
        s.print(ans);
    }


}
