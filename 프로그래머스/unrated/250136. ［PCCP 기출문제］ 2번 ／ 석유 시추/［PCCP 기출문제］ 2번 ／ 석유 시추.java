import java.util.*;

class Solution {
    int[][] gid = new int[500][500], land;
    boolean[][] visited = new boolean[500][500];
    int[] dy = {0, 0, 1, -1}, dx = {1, -1, 0, 0};
    Map<Integer, Integer> oil = new HashMap<>();
    
    void bfs(int y, int x, int id){
        int sum = 1;
        Queue<int[]> Q = new LinkedList<>();
        visited[y][x] = true;
        gid[y][x] = id;
        Q.add(new int[]{y, x});
        while(!Q.isEmpty()){
            int[] cur = Q.remove();
            for(int i = 0; i < 4; i++){
                int ny = cur[0] + dy[i], nx = cur[1] + dx[i];
                if(ny < 0 || nx < 0 || ny >= land.length || nx >= land[0].length || land[ny][nx] == 0)
                    continue;
                if(visited[ny][nx])
                    continue;
                visited[ny][nx] = true;
                gid[ny][nx] = id;
                Q.add(new int[]{ny, nx});
                sum++;
            }
        }
        oil.put(id, sum);
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        int id = 0;
        this.land = land;
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 0 || visited[i][j])
                    continue;
                bfs(i, j, id);
                id++;
            }
        }
        for(int i = 0; i < land[0].length; i++){
            Set<Integer> ids = new HashSet<>();
            int tmp = 0;
            for(int j = 0; j < land.length; j++){
                if(land[j][i] == 0)
                    continue;
                if(!ids.contains(gid[j][i])){
                    ids.add(gid[j][i]);
                    tmp += oil.get(gid[j][i]);
                }
            }
            answer = Math.max(answer, tmp);
        }
        return answer;
    }
}