import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs=new HashSet<>();
        String[] sorted=Arrays.stream(phone_book)
            .sorted(Comparator.comparing(String::length))
            .toArray(String[]::new);
        for(String s:sorted){
            StringBuilder sb=new StringBuilder();
            int len=s.length();
            for(int i=0;i<len;i++){
                sb.append(s.charAt(i));
                if(hs.contains(sb.toString()))
                    return false;
            }
            hs.add(s);
        }
        return true;
    }
}