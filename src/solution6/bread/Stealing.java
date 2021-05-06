package solution6.bread;

public class Stealing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] money = {90, 0, 0, 95, 1, 1};
		Stealing temp = new Stealing();
		System.out.println(temp.solution(money));
	}

	public int solution(int[] money) {
		int answer = 0;
        int len = money.length;
        
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        
        // 현재 위치 : i
        // max : dp[i-2] + money[i] || dp[i-1]
        // 첫 집
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        dp2[0] = 0;
        dp2[1] = money[1];
        
        
        // i = 방문 집
        for(int i=2; i<len-1; i++) {
           dp1[i] = Math.max(dp1[i-1], money[i] + dp1[i-2]);
        }
        // i = 방문 집
        for(int i=2; i<len; i++) {
           dp2[i] = Math.max(dp2[i-1], money[i] + dp2[i-2]);
        }
        
        Arrays.sort(dp1);
        Arrays.sort(dp2);
        
        return Math.max(dp1[len-1], dp2[len-1]);
	}
    
    public void printTable(int[] table) {
        for(int i=0; i<table.length; i++) {
            System.out.print(table[i] + " ");   
        }
        System.out.println();
        System.out.println();
    }
}
