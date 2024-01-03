import java.util.*;

class Solution {
    int m,n;
    
    int getDistance(int x1, int y1, int x2, int y2){
        List<int[]> pos = new ArrayList<>();
        pos.add(new int[]{x2,-y2});
        pos.add(new int[]{x2,2*n-y2});
        pos.add(new int[]{-x2,y2});
        pos.add(new int[]{2*m-x2,y2});
        int ret = Integer.MAX_VALUE;
        for(int[] p : pos){
            int dis1 = (int)(Math.pow(x1-p[0],2)+Math.pow(y1-p[1],2));
            int dis2 = (int)(Math.pow(x2-p[0],2)+Math.pow(y2-p[1],2));
            if(((p[0]==x1&&x1==x2)||(p[1]==y1&&y1==y2))&&dis2<=dis1)
                continue;
            ret = Math.min(ret, dis1);
        }
        return ret;
    }
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        this.m = m;
        this.n = n;
        int[] answer = new int[balls.length];
        for(int i=0;i<answer.length;i++)
            answer[i] = getDistance(startX,startY,balls[i][0],balls[i][1]);
        return answer;
    }
}