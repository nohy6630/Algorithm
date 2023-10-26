import java.util.*;
import java.util.stream.*;

class Solution {
    int[][] dp=new int[200][200];
    
    public int solution(int[][] matrix_sizes) {
        for(int i=0;i<matrix_sizes.length-1;i++){
            dp[i][i+1]=matrix_sizes[i][0]*matrix_sizes[i][1]*matrix_sizes[i+1][1];
            System.out.println(dp[i][i+1]);
        }
        for(int d=2;d<matrix_sizes.length;d++){
            for(int i=0;i+d<matrix_sizes.length;i++){
                int j=i+d;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++)
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+matrix_sizes[i][0]*matrix_sizes[j][1]*matrix_sizes[k][1]);
            }
        }
        return dp[0][matrix_sizes.length-1];
    }
}