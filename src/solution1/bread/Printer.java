package solution1.bread;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Stack;

public class Printer {

    public static class Solution {
        public void print(Queue<Integer> q) {
            q.stream().forEach(i-> System.out.print("["+i+"]"));
            System.out.println();
        }
        public void print(int[] q) {
            Arrays.stream(q).forEach(i-> System.out.print("["+i+"]"));
        }
        public void print(int ans) {
            System.out.println("[" + ans + "]");
        }

        public int solution(int[] priorities, int location) {
            int answer = 0;

            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

            // 문서의 위치
            for(int i=0; i<priorities.length ; i++) {
                q1.offer(i);
            }
            // 문서의 중요도
            Arrays.stream(priorities).forEach(i -> q2.offer(i));

            while(!q2.isEmpty()) {
                int out1 = q1.poll();
                int out2 = q2.poll();

                if( q2.stream().filter(i-> out2<i).count() > 0 ) {
                    // 중요도가 높은 문서가 존재함.
                    q1.offer(out1);
                    q2.offer(out2);
                } else {
                    // 인쇄
                    if(out1 == location) {
                        answer = priorities.length - q2.size();
                        break;
                    }
                }

            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] priorities = {2,1,3,2};
        int location = 2;

        int ans4 = s.solution(priorities, location);
        s.print(ans4);
    }


}
