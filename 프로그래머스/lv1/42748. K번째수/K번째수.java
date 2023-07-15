import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer=new ArrayList<>();
        for(int a=0;a<commands.length;a++){
            int i=commands[a][0],j=commands[a][1],k=commands[a][2];
            int[] sliced=Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(sliced);
            answer.add(sliced[k-1]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}