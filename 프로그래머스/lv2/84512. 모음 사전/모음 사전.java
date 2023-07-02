import java.util.*;
class Solution {
    List<String> words=new ArrayList<>();
    void dfs(String word){
        if(word.length()>5)
            return;
        words.add(word);
        for(int i=0;i<5;i++){
            dfs(word+"AEIOU".charAt(i));
        }
    }
    public int solution(String word) {
        dfs("");
        return words.indexOf(word);
    }
}