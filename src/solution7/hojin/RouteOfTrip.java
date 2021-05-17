package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class RouteOfTrip {

	static String answer = "";

	public static void main(String[] args) {
		RouteOfTrip temp = new RouteOfTrip();
		temp.solution();
	}

	public String[] solution() {
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				int[] checkArray = new int[tickets.length];
				checkArray[i] = 1;
				LinkedList<String> answerList = new LinkedList<String>();
				answerList.add("ICN");
				answerList.add(tickets[i][1]);
				dfs(tickets, tickets[i][1], checkArray, answerList);
			}
		}

		return answer.split(",");
	}

	public void dfs(String[][] ticketsInput, String destString, int[] checkArrayInput,
			LinkedList<String> answerListInput) {
//		if (!IntStream.of(checkArrayInput).anyMatch(x->x == 0)) {
		if (!Arrays.stream(checkArrayInput).anyMatch(i -> i == 0)) {
			System.out.println("~!~!");
			System.out.println(String.join("", answerListInput));
			System.out.println(answer);
			if (String.join(",", answerListInput).compareTo(answer) > 0 && answer.equals("")) {
				answer = String.join(",", answerListInput);
			}
			if (String.join(",", answerListInput).compareTo(answer) < 0 && !answer.equals("")) {
				answer = String.join(",", answerListInput);
			}
			System.out.println(answer);
			System.out.println("~!~!");
			return;
		}
		for (int j = 0; j < ticketsInput.length; j++) {
			if (checkArrayInput[j] == 1) {
				continue;
			} else {
				if (destString.equals(ticketsInput[j][0])) {
					checkArrayInput[j] = 1;
					answerListInput.add(ticketsInput[j][1]);
					dfs(ticketsInput, ticketsInput[j][1], checkArrayInput, answerListInput);
					checkArrayInput[j] = 0;
					answerListInput.removeLast();
				}
			}
		}
	}

}
