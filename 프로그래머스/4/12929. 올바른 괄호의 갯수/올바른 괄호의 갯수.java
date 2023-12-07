import java.util.*;
import java.util.stream.*;

class Solution {
    int n;
    int answer=0;
    Deque<Character> S = new ArrayDeque<>();
    
    void dfs(int l,int r){
        if(l>r||l<0||r<0)
            return;
        if(l==0&&r==0)
            answer++;
        dfs(l-1,r);
        dfs(l,r-1);
    }
    
    public int solution(int n) {
        this.n=n;
        dfs(n,n);
        return answer;
    }
}