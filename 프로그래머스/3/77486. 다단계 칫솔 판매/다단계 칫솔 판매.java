import java.util.*;

class Solution {
    int[] answer;
    List<Integer>[] G;
    Map<String,Integer> M = new HashMap<>();
    
    void dfs(int x, int amount){
        if(amount==0)
            return;
        answer[x]+=amount-amount/10;
        for(int adj:G[x])
            dfs(adj,amount/10);
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        G = new ArrayList[enroll.length];
        for(int i=0;i<G.length;i++)
            G[i] = new ArrayList<>();
        for(int i=0;i<enroll.length;i++)
            M.put(enroll[i],i);
        for(int i=0;i<referral.length;i++){
            if(referral[i].equals("-"))
                continue;
            int idx = M.get(referral[i]);
            G[i].add(idx);
        }
        for(int i=0;i<seller.length;i++)
            dfs(M.get(seller[i]),amount[i]*100);
        return answer;
    }
}