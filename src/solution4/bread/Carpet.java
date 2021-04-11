package solution4.bread;

import util.Util;

public class Carpet {
    public static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            // 가로 w
            // 세로 h : brown/2 - w

            // 갈색 수 =  2*(w-1) + 2*(h-1)
            // 2*(4-1) + 2*(3-1) = 6+4 = 10
            // 노란색 수 = (w-2) * (h-2)

            for(int w=2; w<brown-4; w++) {
                int h = (brown-(w*2) + 4 )/2;

                int calcY = (w-2) * (h-2);

                int calcB = 2*(w-1) + 2*(h-1);


                if(calcY == yellow) {
                    if(w>=h) {
                        answer[0] = w;
                        answer[1] = h;
                    } else {
                        answer[1] = w;
                        answer[0] = h;
                    }

                    break;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int brown = 10;
        int yellow = 2;

        int[] ans = s.solution(brown, yellow);

        Util.print(ans);
    }
}
