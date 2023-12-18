import java.util.*;

class Solution {
    int time2sec(String time){
        int sec;
        sec = Integer.parseInt(time.substring(3,5));
        sec += Integer.parseInt(time.substring(0,2)) * 60;
        return sec;
    }
    
    String sec2time(int sec){
        String m = String.valueOf(sec/60);
        String s = String.valueOf(sec%60);
        if(m.length()<2)
            m="0"+m;
        if(s.length()<2)
            s="0"+s;
        return m+":"+s;
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = new int[timetable.length];
        for(int i=0;i<times.length;i++)
            times[i]=time2sec(timetable[i]);
        Arrays.sort(times);
        int[] cnt = new int[n];
        int lastTime = 0;
        for(int time : times){
            int a;
            if(time<=540)
                a = 0;
            else
                a = (time-540-1)/t+1;
            for(int i=a;i<n;i++)
            {
                if(cnt[i]<m){
                    cnt[i]++;
                    lastTime=time;
                    break;
                }
            }
        }
        if(cnt[n-1]<m)
            return sec2time(540+t*(n-1));
        else
            return sec2time(lastTime-1);
    }
}