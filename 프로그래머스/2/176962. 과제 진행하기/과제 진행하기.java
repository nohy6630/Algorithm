import java.util.*;

class Solution {    
    class Homework{
        String name;
        int start;
        int time;
        
        Homework(String name, int start, int time){
            this.name = name;
            this.start = start;
            this.time = time;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int cnt = 0;
        Deque<Homework> S = new ArrayDeque<>();
        Homework[] homeworks = new Homework[plans.length];
        for(int i=0;i<plans.length;i++){
            int h = Integer.parseInt(plans[i][1].substring(0,2));
            int m = Integer.parseInt(plans[i][1].substring(3,5));
            int playtime = Integer.parseInt(plans[i][2]);
            homeworks[i] = new Homework(plans[i][0], h * 60 + m, playtime);
        }
        Arrays.sort(homeworks, (a,b)->{
            return a.start - b.start;
        });
        Homework cur = homeworks[0];
        for(int i=1;i<homeworks.length;i++){
            Homework next = homeworks[i];
            if(cur.start+cur.time<=next.start){
                answer[cnt++] = cur.name;
                int remainder = next.start-(cur.start+cur.time);
                while(!S.isEmpty()&&remainder>0){
                    Homework top = S.getFirst();
                    if(remainder>=top.time){
                        remainder-=top.time;
                        answer[cnt++] = top.name;
                        S.removeFirst();
                    }
                    else{
                        top.time-=remainder;
                        remainder=0;
                    }
                }
            }
            else{
                cur.time=cur.start+cur.time-next.start;
                S.addFirst(cur);
            }
            cur = next;
        }
        answer[cnt++] = homeworks[homeworks.length-1].name;
        while(!S.isEmpty()){
            Homework top = S.remove();
            answer[cnt++] = top.name;
        }
        return answer;
    }
}