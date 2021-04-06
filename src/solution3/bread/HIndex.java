package solution3.bread;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class HIndex {

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

        public int solution(int[] citations) {
            int answer=0, h=0, k=0;
            int n = citations.length;

            Arrays.sort(citations);

            for(int i=0 ; i<n ; i++) {
                // 인용된 수
                h=citations[i];
                // h 이상 인용된 수
                k=n-i;

                if(h >= k) {
                    answer = k;
                    break;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] citations = {3,0,6,1,5};
//        int[] citations = {2,2,2,2,2};
        int ans1 = s.solution(citations);

        s.print(ans1);

    }
}
