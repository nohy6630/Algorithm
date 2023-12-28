import java.util.*;

class Solution {
    String[] words;
    String target;
    boolean[] visited = new boolean[50];
    int answer = Integer.MAX_VALUE;
    
    boolean chkMove(String a, String b){
        int cnt = 0;
        int len = Math.max(a.length(), b.length());
        for(int i = 0; i < len; i++){
            if(a.charAt(i) != b.charAt(i))
                cnt++;
            if(cnt > 1)
                return false;
        }
        return cnt == 1;
    }
    
    void dfs(String s, int dis){
        if(s.equals(target))
            answer = Math.min(answer, dis);
        for (int i = 0; i < words.length; i++){
            if (visited[i])
                continue;
            if(!chkMove(s, words[i]))
                continue;
            visited[i] = true;
            dfs(words[i], dis + 1);
            visited[i] = false;
        }
        return;
    }
    
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        this.target = target;
        dfs(begin, 0);
        if(answer == Integer.MAX_VALUE)
            answer = 0;
        return answer;
    }
}