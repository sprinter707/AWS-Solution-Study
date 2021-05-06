package solution7.bread;

public class FindNetwork {
    public boolean[] dfs(int[][] computers, int i, boolean[] connected) {
        // 연결 네트워크 찾기
        // 자기자신은 연결되어있음으로 표시.
        connected[i] = true;

        for (int j = 0; j < computers.length; j++) {
            // 1. 현재 컴퓨터와 같지 않은 컴퓨터
            // 2. i 컴퓨터와 j 컴퓨터가 연결되어 있을 때,
            // 3. 다른 네트워크에 속해있지 않을 때.
            if (i != j && computers[i][j] == 1 && connected[j] == false) {
                connected = dfs(computers, j, connected);
            }
        }
        return connected;
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] connected = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!connected[i]) {
                dfs(computers, i, connected);
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

		FindNetwork temp = new FindNetwork();
		
		System.out.println(temp.solution(n, computers));
	}
}