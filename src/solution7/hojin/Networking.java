package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

public class Networking {

	public static void main(String[] args) {
		Networking temp = new Networking();
		temp.solution();
	}

	public int solution() {
		int answer = 0;
		int n = 6;
		int[][] computers = { { 1, 0, 1, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1 }, { 1, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1 } };
		int[] tempArray = new int[n];

		for (int i = 0; i < computers.length; i++) {
			if (tempArray[i] == 0) {
				answer++;
				dfs(i, computers, tempArray);
			} else {
				continue;
			}
		}

		System.out.println(answer);
		return answer;
	}

	public void dfs(int i, int[][] computersInput, int[] tempArrayInput) {

		if (tempArrayInput[i] != 0) {
			return;
		}
		tempArrayInput[i] = 1;
		for (int j = 0; j < computersInput[i].length; j++) {
			if (i == j) {
				continue;
			} else if (computersInput[i][j] != 0 && j != i) {
				computersInput[i][j] = 0;
				computersInput[j][i] = 0;
				dfs(j, computersInput, tempArrayInput);
			} else {
				continue;
			}
		}
	}

}
