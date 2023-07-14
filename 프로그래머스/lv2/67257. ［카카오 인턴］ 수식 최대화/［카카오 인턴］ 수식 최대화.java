import java.util.*;
import java.util.stream.*;

class Solution {
    List<String> nums, ops;
    
    long calculate(long a, long b, char op)
    {
        if(op == '-')
            return a - b;
        if(op == '+')
            return a + b;
        if(op == '*')
            return a * b;
        return -1;
    }
    
    long calculate(char[] order){
        List<Long> vals = nums.stream()
            .map(Long::parseLong)
            .collect(Collectors.toList());
        List<String> ops2 = new ArrayList<>(ops);
        for(int j=0; j<3; j++){
            for(int i=0; i<ops2.size(); i++){
                if(ops2.get(i).charAt(0) == order[j]){
                    long res = calculate(vals.get(i), vals.get(i+1), order[j]);
                    vals.set(i, res);
                    vals.remove(i + 1);
                    ops2.remove(i);
                    i--;
                }
            }
        }
        return vals.get(0);
    }
    
    public long solution(String expression) {
        long ans = 0;
        nums = Arrays.stream(expression.split("[\\+\\-\\*]"))
            .collect(Collectors.toList());
        ops = Arrays.stream(expression.split("[0-9]+"))
            .collect(Collectors.toList());;
        ops.remove(0);
        char[][] order = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '-', '+'},
            {'*', '+', '-'}
        };
        for(int i=0; i<6; i++){
            long res = Math.abs(calculate(order[i]));
            ans = Math.max(ans, res);
        }
        return ans;
    }
}