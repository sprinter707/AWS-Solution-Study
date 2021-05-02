package solution5.bread;

import java.util.*;

public class CheckingCamera {

	public int solution(int[][] routes) {
		int answer=0;

		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});

		// 겹침 구간 표현을 위한 start, end
		int start = -30000;
		int end = 30000;

		for(int i=0 ; i<routes.length; i++) {
			start = routes[i][0];

			// 카메라 추가 후 새로운 구간으로 분리
			if(start>end) {
				answer += 1;
				end = routes[i][1];
			}

			// 구간 겹침
			if (routes[i][1]<end) {
				end = routes[i][1];
			}
		}
		return answer+1;
	}

	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};

		CheckingCamera tn = new CheckingCamera();
		int answer = tn.solution(routes);
		System.out.println(answer);
	}

}
