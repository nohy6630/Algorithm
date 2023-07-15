import java.util.*;

class Solution {
    public String solution(String s) {
        List<Character> chars = new ArrayList<>();
        for(int i=0;i<s.length();i++)
            chars.add(s.charAt(i));
        Collections.sort(chars, (a, b)->{
            if(Character.isUpperCase(a) == Character.isUpperCase(b))
                return b-a;
            if(Character.isUpperCase(a))
                return 1;
            return -1;
        });
        String str = "";
        for(char c : chars)
            str = str + c;
        return str;
    }
}