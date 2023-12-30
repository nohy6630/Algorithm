import java.util.*;

class Solution {
    int[][] dpMin = new int[101][101], dpMax = new int[101][101];
    int[] sign = new int[101];
    
    public int solution(String arr[]) {
        int idx = 0;
        for(String s : arr){
            if(s.equals("-") || s.equals("+")){
                if(s.equals("-"))
                    sign[idx] = -1;
                else
                    sign[idx] = 1;
                continue;
            }
            dpMax[idx][idx] = dpMin[idx][idx] = Integer.parseInt(s);
            idx++;
        }
        for(int d=1; d<idx; d++){
            for(int i=0; i<idx; i++){
                int j = i + d;
                if(j >= idx)
                    continue;
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    if(sign[k+1] == 1){
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] + sign[k+1] * dpMin[k+1][j]);
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] + sign[k+1] * dpMax[k+1][j]);
                    }
                    else{
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] + sign[k+1] * dpMax[k+1][j]);
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] + sign[k+1] * dpMin[k+1][j]);
                    }                  
                }
            }
        }
        return dpMax[0][idx-1];
    }
}