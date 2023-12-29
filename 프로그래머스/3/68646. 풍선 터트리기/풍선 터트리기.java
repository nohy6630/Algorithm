class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] lMin = new int[a.length], rMin = new int[a.length];
        int tmp = Integer.MAX_VALUE;
        for(int i = 1; i < a.length; i++){
            tmp = Math.min(tmp, a[i - 1]);
            lMin[i] = tmp;
        }
        tmp = Integer.MAX_VALUE;
        for(int i = a.length - 2; i >= 0; i--){
            tmp = Math.min(tmp, a[i + 1]);
            rMin[i] = tmp;
        }
        if(a.length == 1)
            return 1;
        answer = 2;
        for(int i = 1; i < a.length - 1; i++){
            if(a[i] < lMin[i] || a[i] < rMin[i])
                answer++;
        }
        return answer;
    }
}