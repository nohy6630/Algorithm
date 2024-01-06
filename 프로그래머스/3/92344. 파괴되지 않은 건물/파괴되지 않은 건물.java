class Solution {
    int[][] sum = new int[1001][1001];
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        for(int[] s : skill){
            int sign = s[0]==1?-1:1;
            sum[s[1]][s[2]] += sign*s[5];
            sum[s[1]][s[4]+1] -= sign*s[5];
            sum[s[3]+1][s[2]] -= sign*s[5];
            sum[s[3]+1][s[4]+1] += sign*s[5];
        }
        for(int i=1;i<board.length;i++){
            for(int j=0;j<board[0].length;j++)
                sum[i][j] += sum[i-1][j];
        }
        for(int i=1;i<board[0].length;i++){
            for(int j=0;j<board.length;j++)
                sum[j][i] += sum[j][i-1];
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                sum[i][j]+=board[i][j];
                if(sum[i][j]>0)
                    answer++;
            }
        }
        return answer;
    }
}