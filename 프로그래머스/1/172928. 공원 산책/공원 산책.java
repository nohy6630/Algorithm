import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int y=0,x=0;
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                if(park[i].charAt(j) == 'S'){
                    y = i;
                    x = j;
                }
            }
        }
        Map<String, int[]> dpos = new HashMap<>();
        dpos.put("E", new int[]{0,1});
        dpos.put("W", new int[]{0,-1});
        dpos.put("N", new int[]{-1,0});
        dpos.put("S", new int[]{1,0});
        for(String r : routes){
            String[] s = r.split(" ");
            int[] d = dpos.get(s[0]);
            int cnt = Integer.parseInt(s[1]);
            int ty=y, tx=x;
            for(int i=0;i<cnt;i++){
                y+=d[0];
                x+=d[1];
                if(y<0||x<0||y>=park.length||x>=park[0].length()||park[y].charAt(x)=='X'){
                    y=ty;
                    x=tx;
                    break;
                }
            }
        }
        return new int[]{y,x};
    }
}