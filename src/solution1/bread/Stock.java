package solution1.bread;

import java.util.*;

public class Stock {

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

        public int[] solution(int[] prices) {
            int fullTime = prices.length;
            int[] answer = new int[fullTime];
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(0);

            for(int i=1; i<fullTime; i++) {
                while(!stack.empty() && prices[stack.peek()] > prices[i]){
                    int idx = stack.pop();
                    answer[idx] = i - idx;
                }

                stack.push(i);
            }

            while(!stack.empty()) {
                int time = stack.pop();
                answer[time] = fullTime - time - 1;
            }

            return answer;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] price = {3,2,3,2,3};
        int[] ans2 = s.solution(price);
        s.print(ans2);

    }
}
