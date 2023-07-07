class Solution {
    public int[] solution(int brown, int yellow) {
        int sum=brown/2+2;
        for(int h=3;h<=sum/2;h++){
            int w=sum-h;
            if((w-2)*(h-2)==yellow)
                return new int[]{w,h};
        }
        return null;
    }
}