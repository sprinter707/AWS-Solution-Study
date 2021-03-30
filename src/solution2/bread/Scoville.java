package solution2.bread;

import java.util.PriorityQueue;

public class Scoville {

    public static class Solution {
        public void print(int ans) {
            System.out.println("[" + ans + "]");
        }

        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int sco : scoville) {
                pq.offer(sco);
            }

            int min1, min2, result;

            while(true){
                if(pq.peek() > K) {
                    break;
                }

                if(pq.size() == 1) {
                    answer = -1;
                    break;
                }
                answer++;

                // 가장 맵지 않은 음식의 스코빌 지수 - a
                min1 = pq.poll();
                // 두 번째로 맵지 않은 음식의 스코빌 지수 - b
                min2 = pq.poll();

                // 섞은 음식의 스코빌 지수 = a + 2b
                result = min1 + (2*min2);

                pq.offer(result);

            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        int ans = s.solution(scoville, k);
        s.print(ans);
    }


}
