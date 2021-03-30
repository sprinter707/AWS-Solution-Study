package solution2.bread;

import java.util.*;

public class DoublePriorityQueue {
    public static class Solution {
        public void print(int ans) {
            System.out.println("[" + ans + "]");
        }
        public void print(LinkedList<Integer> q) {
            q.stream().forEach(o->System.out.print("[" + o + "]"));

        }
        public void print(int[] q) {
            Arrays.stream(q).forEach(i-> System.out.print("["+i+"]"));
        }

        public int[] solution(String[] operations) {
            int[] answer = new int[2];

            LinkedList<Integer> q = new LinkedList<>();

            for(int i=0; i < operations.length ; i++) {
                String[] s = operations[i].split(" ");

                String operation = s[0];
                int number = Integer.parseInt(s[1]);
                
                if(operation.equals("I")) {
                    // 삽입
                    q.offer(number);
                    // 오름차순 정렬
                    Collections.sort(q);
                } else if(operation.equals("D") && !q.isEmpty()) {
                    // 삭제
                    if(number > 0) {
                        // 최댓값 삭제
                        q.removeLast();
                    } else {
                        // 최솟값 삭제
                        q.removeFirst();
                    }
                }
            }

            Collections.sort(q);

            if(q.isEmpty()) {
                answer[0] = 0;
                answer[1] = 0;
            } else {
                answer[1] = q.getFirst();
                answer[0] = q.getLast();
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] operations = { "I 16", "D 1" };
        String[] operations2 = { "I 7", "I 5", "I -5", "D -1" };
        String[] op3 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] ans = s.solution(op3);
        System.out.println();
        s.print(ans);
    }
}
