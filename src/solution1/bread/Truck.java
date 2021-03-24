package solution1.bread;

import java.util.*;

public class Truck {

    public static class Solution {
        public void print(Queue<Integer> q) {
            q.stream().forEach(i -> System.out.print("[" + i + "]"));
            System.out.println();
        }

        public void print(int[] q) {
            Arrays.stream(q).forEach(i -> System.out.print("[" + i + "]"));
        }

        public void print(int ans) {
            System.out.println("[" + ans + "]");
        }

        public int solution1(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < bridge_length; i++) {
                q.offer(0);
            }

            for (int i = 0; i < truck_weights.length; i++) {
                q.poll();
                answer += 1;

                int nextTruck = truck_weights[i];
                int currWeight = q.stream().mapToInt(num -> num).sum();

                while ((currWeight + nextTruck) > weight) {
                    q.offer(0);

                    currWeight -= q.poll();
                    answer += 1;
                }

                q.offer(nextTruck);
            }

            answer += bridge_length;


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] tw = {7,4,5,6};
        int ans1 = s.solution1(2, 10, tw);
        System.out.println(ans1);

    }
}
