import java.util.*;

class Solution {
    int answer = 0;
    
    void dfs(int h,int p){
        if(h<3||(int)(Math.log(h)/Math.log(3))<p/2)
            return;
        if(h==3&&p==2){
            answer++;
            return;
        }
        dfs(h-1,p+1);
        if(h%3==0&&p>=2)
            dfs(h/3,p-2);
            
    }
    
    public int solution(int n){
        dfs(n,0);
        return answer;
    }
}