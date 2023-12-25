import java.util.*;
import java.util.regex.*;
import java.time.*;
import java.time.format.*;

class Solution {
    long[] start, end;
    Pattern pattern = Pattern.compile("(.*) ([\\d.]*)s");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    
    public int solution(String[] lines) {
        int answer = 0;
        start = new long[lines.length];
        end = new long[lines.length];
        for(int i=0;i<lines.length;i++){
            Matcher matcher = pattern.matcher(lines[i]);
            matcher.find();
            LocalDateTime endTime = LocalDateTime.parse(matcher.group(1), formatter);
            Double process = Double.parseDouble(matcher.group(2));
            end[i] = endTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            start[i] = end[i] - (long)(process * 1000) + 1;
        }
        for(int i=0;i<lines.length;i++){
            int cnt = 1;
            for(int j=i+1;j<lines.length;j++){
                if(start[j]<end[i]+1000)
                    cnt++;
            }
            answer = Math.max(answer,cnt);
        }
        return answer;
    }
}