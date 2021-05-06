package solution7.bread;

public class TargetNumber {
    public int TARGET_NUMBER;
    
    public int find(int[] numbers, int sum, int depth) {
        int res=0;
        if(depth == numbers.length) {
            if(sum == TARGET_NUMBER) {
                return 1;
            } else {
                return 0;
            }
        }
        
        
        res += find(numbers, sum+numbers[depth], depth+1);
        res += find(numbers, sum-numbers[depth], depth+1);
        
        return res;
        
    }
    
    public int solution(int[] numbers, int target) {
        TARGET_NUMBER = target;
        
        int answer = 0;
        
        answer = find(numbers, 0, 0);
        
        return answer;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] numbers = {1,1,1,1,1};
        int target = 3;

		TargetNumber temp = new TargetNumber();
		
		System.out.println(temp.solution(numbers, target));
	}
}