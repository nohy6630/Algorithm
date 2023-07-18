import java.util.*;

class Solution {
    int n;
    int[] times;
    
    boolean isValid(long t){
        long sum = 0;
        for(int i : times)
            sum += (long)(t / i);
        return sum >= n;
    }
    
    public long solution(int n, int[] times) {
        this.n = n;
        this.times = times;
        long l = 1, r = 1000000000000000000L;
        while (l <= r){
            long m = (l + r) / 2;
            if(isValid(m))
                r = m - 1;
            else
                l = m + 1;
        }
        return l;
    }
}