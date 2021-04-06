package solution3.bread;

import java.util.Arrays;
import java.util.Queue;

public class MaximumNumber {

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

        public void print(String s) { System.out.println(s); }

        public String solution(int[] nums) {
            String answer = "";
            String[] temp = new String[nums.length];

            for(int i=0; i<nums.length; i++) {
                temp[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(temp, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));

            if(temp[0].equals("0")) return "0";

            for(int i=0; i<temp.length; i++) {
                answer += temp[i];
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {6,10,2};

        String ans1 = s.solution(nums);

        s.print(ans1);

    }
}
