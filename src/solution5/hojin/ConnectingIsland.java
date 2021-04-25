package algorithm;

import java.util.ArrayList;
import java.util.Comparator;

public class ConnectingIsland {
	int[] findParent;
	public int find(int child) {
		if(findParent[child] == child) {
			return child;
		}else {
			findParent[child] = find(findParent[child]);
			return findParent[child];
		}
	}
	
	public int solution() {

		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		int n = 4;
		int answer = 0;
		ArrayList<Cost> tempCosts = new ArrayList<Cost>();
		for (int i = 0; i < costs.length; i++) {
			tempCosts.add(new Cost(costs[i][0], costs[i][1], costs[i][2]));
		}

		tempCosts.sort(new Comparator<Cost>() {
			@Override
			public int compare(Cost o1, Cost o2) {
				return o1.cost - o2.cost;
			}
		});
		
		tempCosts.stream().forEach(x->System.out.println(x.cost));
		
		findParent = new int[n];
		for(int i = 0 ; i < n ; i ++) {
			findParent[i] = i;
		}
		
		for(int j = 0 ; j < tempCosts.size() ; j++) {
			int firstIsland = find(tempCosts.get(j).from);
			int SecondIsland = find(tempCosts.get(j).dest);
			if(firstIsland != SecondIsland) {
				findParent[SecondIsland] = firstIsland;
				answer += tempCosts.get(j).cost;
			}
		}

		return answer;
	}

	class Cost {
		int from;
		int dest;
		int cost;

		Cost(int from, int dest, int cost) {
			this.from = from;
			this.dest = dest;
			this.cost = cost;
		}

		int getFrom() {
			return from;
		}

		int getDest() {
			return dest;
		}

		int getCost() {
			return cost;
		}

	}

	public static void main(String[] args) {
		ConnectingIsland tn = new ConnectingIsland();
		tn.solution();

	}

}
