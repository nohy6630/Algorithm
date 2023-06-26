class Solution {
    
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int row=arr1.length,col=arr2[0].length,mid=arr2.length;
        int[][] answer = new int[row][col];
        for(int y=0;y<row;y++)
        {
            for(int x=0;x<col;x++)
            {
                for(int i=0;i<mid;i++)
                    answer[y][x]+=arr1[y][i]*arr2[i][x];
            }
        }
        return answer;
    }
}
