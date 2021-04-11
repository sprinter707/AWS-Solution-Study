package solution4.bread;

import util.Util;

import java.util.ArrayList;

public class GymClothes {
    public static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int[] student = new int[n+2];
            ArrayList<Integer> lostPeople = new ArrayList<>();

            // 학생은 1번부터 시작 (0번 학생과 n+1 번 학생을 만들고 옷은 0개라 입력)
            for(int i=1; i <= n ; i++) {
                student[i] = 1;
            }

            // 여벌 옷 보유 학생 표시
            for(int resv : reserve) {
                student[resv] = 2;
            }

            for(int lostPerson : lost) {
                if(student[lostPerson] == 2) {
                    // 잃어버린학생이 여벌이 있는경우
                    student[lostPerson] = 1;
                } else {
                    lostPeople.add(lostPerson);
                }
            }

            for(int lostPerson : lostPeople) {

                if(student[ lostPerson-1 ] > 1) {
                    // 앞학생이 여벌이 있는경우
                    student[lostPerson] = 1;
                    student[lostPerson-1] = 1;
                } else if( student[ lostPerson + 1 ] > 1) {
                    // 뒷학생이 여벌이 있는경우
                    student[lostPerson] = 1;
                    student[lostPerson + 1] = 1;
                } else {
                    System.out.println(lostPerson);
                    // 여벌옷이 없는 경우
                    student[lostPerson] = 0;
                }
            }

            for(int i=0; i<student.length ; i++) {
                // 체육복을 가진 학생
                if(student[i] > 0) {
                    answer+=1;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int n=5;
        // 잃어 버린 학생
        int[] lost = {1,2,3};
        // 여유있는 학생
        int[] reserve = {2,3,4};

        int ans = s.solution(n, lost, reserve);

        Util.print(ans);
    }
}
