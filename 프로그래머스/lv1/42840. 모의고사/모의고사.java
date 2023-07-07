import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer=new ArrayList<>();
        int max=0;
        int[][] select={
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        for(int i=0;i<3;i++){
            int score=0;
            for(int j=0;j<answers.length;j++){
                if(answers[j]==select[i][j%select[i].length])
                    score++;
            }
            if(score>=max){
                if(score!=max)
                    answer.clear();
                answer.add(i+1);
                max=score;
            }   
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}