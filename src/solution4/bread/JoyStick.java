package solution4.bread;

import util.Util;

import java.util.HashMap;

public class JoyStick {
    public static class Solution {
        public int solution(String name) {
            int answer = 0;

            int len = name.length();

            //최대로 가질 수 있는 min값은 순차적으로 끝까지 가는것
            int min = len-1;

            for(int i=0; i<len; i++) {
                // A 부터 이동
                answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

                //좌우: 연속된 A의 등장에 따라 최소 움직임이 달라진다

                int next = i+1;// 현재 다음 위치부터

                //내 다음이 A라면 계속 NEXT++
                // A가 연속으로 나오는 지점을 계산하여 맨 앞 또는 맨 뒤로 이동 후 작성하는 경우를 비교
                while(next<len && name.charAt(next) == 'A') {
                    next++;
                }

                min = Math.min(min, i+len-next + i);
            }

            answer += min;

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String name= "JEROEN";

        int ans = s.solution(name);

        Util.print(ans);
    }
}
