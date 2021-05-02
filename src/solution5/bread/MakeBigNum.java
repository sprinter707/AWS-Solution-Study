package solution5.bread;

public class MakeBigNum {
	public String solution(String number, int k) {
		String answer="";
		int answerLength = number.length()-k;

		int index = -1;

		for(int i=answerLength;i>0;i--){
			char max = '0';

			// 선택한 점수 기준으로 뒤의 남은 숫자 자리만큼 비교하며 큰수를 찾는다.
			for(int j = index+1; j<=number.length() -i;j++){
				char temp = number.charAt(j);

				// 가장 큰 수가 나오면 break;
				if(temp == '9') {
					max = temp;
					index = j;
					break;
				}

				if(max < temp){
					max = temp;
					index = j;
				}
			}
			answer+=max;
		}

		return answer;

	}

	public static void main(String[] args) {
		String number1 = "1924";
		String number2 = "1231234";
		String number3 = "4177252841";

		int k = 4;
		MakeBigNum tn = new MakeBigNum();
		String answer = tn.solution(number3, k);

		System.out.println(answer);


	}

}
