import java.util.*;

class Solution {
    List<Integer> nums = new ArrayList<>();
    boolean[][] visited = new boolean[100][100];
    int[] dy = {0,0,-1,1}, dx = {-1,1,0,0};
    String[] maps;
    
    int dfs(int y, int x){
        if(visited[y][x])
            return 0;
        int ret = maps[y].charAt(x) - '0';
        visited[y][x]=true;
        for(int i=0;i<4;i++){
            int ny = y+dy[i], nx = x+dx[i];
            if(ny<0||nx<0||ny>=maps.length||nx>=maps[0].length()||visited[ny][nx]||maps[ny].charAt(nx)=='X')
                continue;
            ret += dfs(ny,nx);
        }
        return ret;
    }
    
    public int[] solution(String[] maps) {
        this.maps = maps;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(visited[i][j]||maps[i].charAt(j)=='X')
                    continue;
                nums.add(dfs(i,j));
            }
        }
        Collections.sort(nums);
        if(nums.isEmpty())
            nums.add(-1);
        int[] answer = new int[nums.size()];
        for(int i=0; i<answer.length;i++)
            answer[i]=nums.get(i);
        return answer;
    }
}