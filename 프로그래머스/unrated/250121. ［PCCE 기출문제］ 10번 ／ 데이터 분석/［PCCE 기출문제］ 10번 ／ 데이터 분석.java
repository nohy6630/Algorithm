import java.util.*;
class Solution {
    Map<String,Integer> idx = new HashMap<>();
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        idx.put("code",0);
        idx.put("date",1);
        idx.put("maximum",2);
        idx.put("remain",3);
        int col = idx.get(ext);
        int sortCol = idx.get(sort_by);
        List<int[]> list = new ArrayList<>();
        for(int[] d : data){
            if(d[col] < val_ext)
                list.add(d);
        }
        Collections.sort(list, (a,b)->{
            return a[sortCol]-b[sortCol];
        });
        int[][] answer = new int[list.size()][];
        for(int i=0;i<answer.length;i++)
            answer[i]=list.get(i);
        return answer;
    }
}