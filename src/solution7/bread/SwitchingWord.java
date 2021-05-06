package solution7.bread;

public class SwitchingWord {
    public int minAnswer;
    public boolean[] used;
    
    public void dfs(String prevWord, String target, int count, String[] words) {
        if(prevWord.equals(target)) {
            minAnswer = (minAnswer>count) ? count : minAnswer;        
            return;
        }
        
        for(int i=0; i<words.length; i++ ) {
            
            if(!used[i] && check(prevWord, words[i])) {
                used[i] = true;
                dfs(words[i], target, count+1, words);
                used[i] = false;
            }
        }
        
    }
    
    public boolean check(String prevWord, String currWord) {
        int count = 0;
        
        for(int i = 0; i < prevWord.length(); i++) {
            if(prevWord.charAt(i) != currWord.charAt(i)) {
                count++;
            }
        }
        
        return count == 1 ? true : false;
    }
    
    public int solution(String begin, String target, String[] words) {
        minAnswer = 51;
        int answer = 0;
        
        used = new boolean[words.length];
        
        dfs(begin, target, 0, words);
        
        return minAnswer==51 ? 0 : minAnswer;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

		SwitchingWord temp = new SwitchingWord();
		
		System.out.println(temp.solution(begin, target, words));
	}
}