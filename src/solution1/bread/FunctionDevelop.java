package solution1.bread;

import java.util.*;

public class FunctionDevelop {

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

        public int[] solution(int[] progresses, int[] speeds) {
            ArrayList<Integer> list = new ArrayList<>();
            int[] answer = {};
            int day = 0;
            int workIdx = 0;
            int deployFuncNumber = 0;

            Queue<Integer> q = new LinkedList<>();

            Arrays.stream(progresses).forEach(i-> q.add(i));

            while(!q.isEmpty()) {
                if(q.peek() + day*speeds[workIdx] >= 100) {
                    q.poll();
                    deployFuncNumber+=1;
                    workIdx+=1;
                } else {
                    if(deployFuncNumber>0) {
                        list.add(deployFuncNumber);
                        deployFuncNumber=0;
                    }
                    day+=1;
                }
            }
            if(deployFuncNumber>0) {
                list.add(deployFuncNumber);
            }

            answer = list.stream().mapToInt(i->i).toArray();

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] ans3 = s.solution(progresses, speeds);

        s.print(ans3);
    }


}
