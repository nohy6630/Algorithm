class Solution {
    int answer, target;
    int[] numbers;
    
    
    void dfs(int val, int idx){
        if(idx==numbers.length){
            if(val==target)
                answer++;
            return;
        }
        dfs(val+numbers[idx],idx+1);
        dfs(val-numbers[idx],idx+1);
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0,0);
        return answer;
    }
}