package algorithm;

import java.util.Comparator;
import java.util.LinkedList;

public class CheckingCamera {

	public int solution() {
		int[][] routes = { {0, 1}, {0, 1}, {1, 2} };
		int answer = 0;
		LinkedList<Route> tempRoutes = new LinkedList<Route>();

		for (int i = 0; i < routes.length; i++) {
			tempRoutes.add(new Route(routes[i][0], routes[i][1]));
		}

		tempRoutes.sort(new Comparator<Route>() {
			@Override
			public int compare(Route o1, Route o2) {
				return o1.from - o2.from;
			}
		});

		while (tempRoutes.size() > 0) {
			Route tempRoute = tempRoutes.poll();
			for (int i = 0; i < tempRoutes.size(); i++) {
				if(tempRoutes.get(i).from > tempRoute.dest) {
					break;
				}
				if( tempRoutes.get(i).from <=tempRoute.dest &&
					tempRoutes.get(i).dest <=tempRoute.dest ) {
					tempRoute.setFrom(tempRoutes.get(i).from);
					tempRoute.setDest(tempRoutes.get(i).dest);
					tempRoutes.remove(i);
					i--;
					continue;
				}
				if( tempRoutes.get(i).from <=tempRoute.dest &&
					tempRoutes.get(i).dest > tempRoute.dest ) {
					tempRoute.setFrom(tempRoutes.get(i).from);
					tempRoutes.remove(i);
					i--;
					continue;
				}
			}
			answer++;
		}
		System.out.println(answer);
		return answer;
	}

	class Route {
		int from;
		int dest;

		Route(int from, int dest) {
			this.from = from;
			this.dest = dest;
		}
		
		void setFrom(int from){
			this.from = from;
		}
		
		void setDest(int dest){
			this.dest = dest;
		}

	}

	public static void main(String[] args) {
		CheckingCamera tn = new CheckingCamera();
		tn.solution();

	}

}
