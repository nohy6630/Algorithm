class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long rr1 = (long)Math.pow(r1,2), rr2 = (long)Math.pow(r2,2);
        for(int x = 0; x < r2; x++){
            long xx = (long)Math.pow(x,2);
            double y2 = Math.sqrt(rr2 - xx);
            if(x>=r1)
                answer+=Math.floor(y2);
            else{
                double y1 = Math.sqrt(rr1 - xx);
                answer += Math.floor(y2) - Math.max(Math.ceil(y1), 1) + 1;
            }
        }
        return answer * 4;
    }
}