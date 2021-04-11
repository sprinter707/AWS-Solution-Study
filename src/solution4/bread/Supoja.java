package solution4.bread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Supoja {
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

        public int[] solution(int[] answers) {
            int[] answer = {};
            int[][] supoja = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};

            int[] cnt = new int[3];

            ArrayList<Integer> list = new ArrayList<Integer>();

            for(int i=0 ; i<answers.length ; i++) {
                if(answers[i] == supoja[0][i%5]) {
                    cnt[0]++;
                }
                if(answers[i] == supoja[1][i%8]) {
                    cnt[1]++;
                }
                if(answers[i] == supoja[2][i%10]) {
                    cnt[2]++;
                }
            }

            int maxScore = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

            if(maxScore == cnt[0]) list.add(1);
            if(maxScore == cnt[1]) list.add(2);
            if(maxScore == cnt[2]) list.add(3);


            return  list.stream().mapToInt(i->i.intValue()).sorted().toArray();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] answers = {1,2,3,4,5};

        int[] ans1 = s.solution(answers);

        s.print(ans1);

    }
}
