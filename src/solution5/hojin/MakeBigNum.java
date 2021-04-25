package algorithm;

public class MakeBigNum {
	public String solution() {
		String number = "999";
		int k = 2;
		int leftLength = number.length() - k;
		int savedLength = 0;
		String answer = "";
		int deletedNum = 0 ;
		for (int i = 0; i < number.length(); i++) {
			boolean deletedCriteria = false;
			if(deletedNum == k) {
				answer += number.substring(i, number.length());
				break;
			}
			if(Integer.parseInt(number.substring(i, i + 1)) == 9){
                savedLength++;
                answer += number.substring(i, i + 1);
                continue;
            }
			for (int j = i + 1; j < number.length(); j++) {
				if (Integer.parseInt(number.substring(i, i + 1)) < Integer.parseInt(number.substring(j, j + 1))) {
					if (number.length() - j >= leftLength - savedLength) {
						deletedCriteria = true;
						deletedNum++;
						break;
					}
				}
			}
			if(!deletedCriteria) {
				answer += number.substring(i, i + 1);
				savedLength++;
			}
		}
		
		if(answer.length() > leftLength) {
			answer = answer.substring(0,leftLength);
		}
	
		return answer;

	}

	public static void main(String[] args) {
		MakeBigNum tn = new MakeBigNum();
		tn.solution();

	}

}
