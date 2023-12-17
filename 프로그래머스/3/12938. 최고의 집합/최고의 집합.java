class Solution {
    public int[] solution(int n, int s) {
        if(n>s)
            return new int[]{-1};
        int[] answer = new int[n];
        for(int i=0;i<answer.length;i++)
            answer[i]+=s/n;
        s-=answer[0]*n;
        for(int i=n-1;i>n-1-s;i--)
            answer[i]++;
        return answer;
    }
}