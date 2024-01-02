import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        Map<String,Integer> fatigue = new HashMap<>();
        fatigue.put("diamond",25);
        fatigue.put("iron",5);
        fatigue.put("stone",1);
        int pickCnt = picks[0] + picks[1] + picks[2];
        List<int[]> fatigues = new ArrayList<>();
        for(int i=0;i<minerals.length&&i<pickCnt*5;i+=5){
            int sum = 0;
            for(int j=0;j<5&&i+j<minerals.length;j++)
                sum += fatigue.get(minerals[i+j]);
            fatigues.add(new int[]{i, sum});
        }
        Collections.sort(fatigues, (a,b)->{
            return b[1]-a[1];
        });
        Map<String,Integer> idx = new HashMap<>();
        idx.put("diamond",0);
        idx.put("iron",1);
        idx.put("stone",2);
        Deque<int[]> S = new ArrayDeque<>();
        while(picks[2]>0){
            S.addFirst(new int[]{25,5,1});
            picks[2]--;
        }
        while(picks[1]>0){
            S.addFirst(new int[]{5,1,1});
            picks[1]--;
        }
        while(picks[0]>0){
            S.addFirst(new int[]{1,1,1});
            picks[0]--;
        }
        for(int[] f : fatigues){
            int[] cur = S.removeFirst();
            for(int i=0;i<5;i++){
                int index = f[0]+i;
                if(index>=minerals.length)
                    continue;
                answer+=cur[idx.get(minerals[index])];
            }
        }
        return answer;
    }
}