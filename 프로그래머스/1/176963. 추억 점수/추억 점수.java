import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> score = new HashMap<>();
        for(int i=0;i<name.length;i++)
            score.put(name[i],yearning[i]);
        for(int i=0;i<photo.length;i++){
            for(String n : photo[i])
                answer[i] += score.getOrDefault(n, 0);
        }
        return answer;
    }
}