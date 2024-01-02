class Solution {
    int chkTree(int[] binary, int l, int r){
        if(l>r)
            return 0;
        int m = (l+r)/2;
        if(binary[m]==0)
            return 0;
        int ret = 1;
        ret += chkTree(binary, l, m-1);
        ret += chkTree(binary, m+1, r);
        return ret;
    }
    
    int chkMakable(long n){
        int[] arr = new int[100];
        int idx = 99;
        long tmp = n;
        while(tmp>0){
            arr[idx] = (int)(tmp%2);
            idx--;
            tmp/=2;
        }
        int digit = (int)Math.pow(2,Math.ceil(Math.log(99-idx+1)/Math.log(2)))-1;
        int[] binary = new int[digit];
        int cnt = 0;
        for(int i=0;i<digit;i++){
            binary[i]=arr[99-digit+1+i];
            if(binary[i]==1)
                cnt++;
        }
        if(chkTree(binary,0,binary.length-1) == cnt)
            return 1;
        return 0;
    }
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0;i<answer.length;i++)
            answer[i]=chkMakable(numbers[i]);
        return answer;
    }
}