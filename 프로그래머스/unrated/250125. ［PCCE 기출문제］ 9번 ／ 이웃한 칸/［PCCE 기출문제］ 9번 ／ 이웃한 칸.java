class Solution {
    int[] dy={-1,1,0,0}, dx={0,0,-1,1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for(int i=0;i<4;i++){
            int ny = h + dy[i], nx = w + dx[i];
            if(ny<0||nx<0||ny>=board.length||nx>=board[0].length)
                continue;
            if(board[h][w].equals(board[ny][nx]))
                answer++;
        }
        return answer;
    }
}