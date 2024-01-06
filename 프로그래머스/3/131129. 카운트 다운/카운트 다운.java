class Solution {
    int[][] dp = new int[100001][2];
    
    public int[] solution(int target) {
        for(int i=0;i<=target;i++){
            dp[i][0]=Integer.MAX_VALUE;
            dp[i][1]=Integer.MIN_VALUE;
        }
        dp[0][0] = dp[0][1] = 0;
        for(int i=0;i<target;i++){
            for(int j=1;j<=20;j++){
                if(i+j>target)
                    break;
                if(dp[i][0]+1<dp[i+j][0]){
                    dp[i+j][0]=dp[i][0]+1;
                    dp[i+j][1]=dp[i][1]+1;
                }
                else if(dp[i][0]+1==dp[i+j][0] && dp[i][1]+1>dp[i+j][1])
                    dp[i+j][1]=dp[i][1]+1;
            }
            for(int j=2;j<=40;j+=2){
                if(i+j>target)
                    break;
                if(dp[i][0]+1<dp[i+j][0]){
                    dp[i+j][0]=dp[i][0]+1;
                    dp[i+j][1]=dp[i][1];
                }
                else if(dp[i][0]+1==dp[i+j][0] && dp[i][1]>dp[i+j][1])
                    dp[i+j][1]=dp[i][1];
            }
            for(int j=3;j<=60;j+=3){
                if(i+j>target)
                    break;
                if(dp[i][0]+1<dp[i+j][0]){
                    dp[i+j][0]=dp[i][0]+1;
                    dp[i+j][1]=dp[i][1];
                }
                else if(dp[i][0]+1==dp[i+j][0] && dp[i][1]>dp[i+j][1])
                    dp[i+j][1]=dp[i][1];
            }
            if(i+50<=target){
                if(dp[i][0]+1<dp[i+50][0]){
                    dp[i+50][0]=dp[i][0]+1;
                    dp[i+50][1]=dp[i][1]+1;
                }
                else if(dp[i][0]+1==dp[i+50][0] && dp[i][1]+1>dp[i+50][1])
                    dp[i+50][1]=dp[i][1]+1;
            }
        }
        return dp[target];
    }
}