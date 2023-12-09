import java.util.*;
import java.util.stream.*;

class Solution {
    int a, b, N;
    int[] g, s, w, t;
    
    public boolean isValid(long time){
        long totalCnt=0, aCnt=0, bCnt=0;
        for(int i=0;i<N;i++){
            long cnt = time/(2L*t[i]);
            if(time%(2L*t[i]) >= t[i])
                cnt++;
            totalCnt+=Math.min(g[i]+s[i],w[i]*cnt);
            aCnt+=Math.min(g[i],w[i]*cnt);
            bCnt+=Math.min(s[i],w[i]*cnt);
        }
        return totalCnt>=a+b && aCnt>=a && bCnt>=b;
    }
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        this.a=a;
        this.b=b;
        this.g=g;
        this.s=s;
        this.w=w;
        this.t=t;
        N=g.length;
        long l=0, r=400000000000000L, m;
        while(l<=r){
            m=(l+r)/2;
            if(isValid(m))
                r=m-1;
            else
                l=m+1;
        }
        return l;
    }
}