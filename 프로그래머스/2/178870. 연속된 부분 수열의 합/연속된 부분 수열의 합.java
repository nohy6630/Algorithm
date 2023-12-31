class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0,Integer.MAX_VALUE};
        int s = 0, e = 0, sum = sequence[0];
        while(true){
            if(sum<=k){
                if(sum==k){
                    if(e-s<answer[1]-answer[0]){
                        answer[0]=s;
                        answer[1]=e;
                    }
                }
                e++;
                if(e>=sequence.length)
                    break;
                sum+=sequence[e];
            }
            else if(sum>k){
                sum-=sequence[s];
                s++;
                if(s>e)
                    break;
            }
        }
        return answer;
    }
}