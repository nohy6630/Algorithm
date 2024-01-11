class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int a=0,b=0;
        for(int i=n-1;i>=0;i--){
            a-=deliveries[i];
            b-=pickups[i];
            while(a<0||b<0){
                a+=cap;
                b+=cap;
                answer+=(i+1)*2;
            }
        }
        return answer;
    }
}