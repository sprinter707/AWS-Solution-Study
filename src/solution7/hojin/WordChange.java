package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class WordChange {

	public static int answer = 51;

	public static void main(String[] args) {
		WordChange temp = new WordChange();
		temp.solution();
	}

	public int solution() {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		if (!Arrays.asList(words).contains(target)) {
			return 0;
		}
		bfs(0, begin, target, words);
		return answer;
	}

	public void bfs(int trial, String beginInput, String targetInput, String[] wordsInput) {
		if (beginInput.equals(targetInput) && answer > trial) {
			answer = trial;
			return;
		}
		for (int i = 0; i < wordsInput.length; i++) {
			if (!beginInput.equals(wordsInput[i]) && compareTwoString(beginInput,wordsInput[i])) {
				ArrayList<String> tempList = new ArrayList<String>(Arrays.asList(wordsInput));
				tempList.remove(wordsInput[i]);
				String[] tempStringArray = tempList.toArray(new String[0]);
				bfs(trial + 1, wordsInput[i], targetInput, tempStringArray);
			} else {
				continue;
			}
		}
	}
	
	public boolean compareTwoString(String inputString1, String inputString2) {
		
		boolean returnBoolean = false;
		int lengthOfString = inputString1.length();
		
		for(int i = 0 ; i < lengthOfString ; i++ ) {
			if(inputString1.substring(0,i).equals(inputString2.substring(0,i)) && !inputString1.substring(i,i+1).equals(inputString2.substring(i,i+1)) && inputString1.substring(i+1,lengthOfString).equals(inputString2.substring(i+1,lengthOfString))) {
				returnBoolean = true;
				break;
			}
		}
		
		return returnBoolean;
	}
}
