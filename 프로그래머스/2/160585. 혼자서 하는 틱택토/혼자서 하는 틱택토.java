class Solution {
    int[][] map = new int[3][3];
    
    int dfs(int t){
        boolean chk = false;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(map[i][j]==1||map[i][j]==2)
                    chk=true;
            }
        }
        if(!chk)
            return 1;
        
        for(int i=0;i<3;i++){
            if(map[i][0]==map[i][1] && map[i][1]==map[i][2] && map[i][0]>=10)
                return -1;
            if(map[0][i]==map[1][i] && map[1][i]==map[2][i] && map[0][i]>=10)
                return -1;
        }
        if(map[0][0]==map[1][1]&&map[1][1]==map[2][2]&&map[0][0]>=10)
            return -1;
        if(map[2][0]==map[1][1]&&map[1][1]==map[0][2]&&map[2][0]>=10)
            return -1;
        
        int a = t%2==0?1:2;
        int ret = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(map[i][j]!=a)
                    continue;
                map[i][j]=a*10;
                if(dfs(t+1)==1)
                    ret = 1;
                map[i][j]=a;
            }
        }
        return ret;
    }
    
    public int solution(String[] board) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                switch(board[i].charAt(j)){
                    case 'O':
                        map[i][j] = 1;
                        break;
                    case 'X':
                        map[i][j] = 2;
                        break;
                    default:
                        map[i][j] = 0;
                }
            }
        }
        return dfs(0);
    }
}