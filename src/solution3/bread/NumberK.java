package solution3.bread;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberK {

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

        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int cntAnswer = 0;

            for(int i=0; i<commands.length ; i++) {
                int[] division = new int[commands[i][1] - commands[i][0] +1];
                int cntDivision = 0;

                for(int j = commands[i][0]-1 ; j<= commands[i][1]-1 ; j++) {
                    division[cntDivision++] = array[j];
                }

                Arrays.sort(division);

                answer[cntAnswer++] = division[commands[i][2]-1];
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        int[] ans1 = s.solution(array, commands);

        s.print(ans1);

    }
}
