class Solution {
    int[] num = {4,1,2};
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>3){
            sb.insert(0,num[n%3]);
            if(n%3==0)
                n--;
            n/=3;
        }
        sb.insert(0,num[n%3]);
        return sb.toString();
    }
}