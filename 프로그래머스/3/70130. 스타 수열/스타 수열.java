import java.util.*;

class Solution {
    class Node{
        int val,cnt;
        Node(int val, int cnt){
            this.val = val;
            this.cnt = cnt;
        }
    }
    public int solution(int[] a) {
        int[] cnt = new int[a.length];
        int answer = 0;
        for(int i=0;i<a.length;i++)
            cnt[a[i]]++;
        List<Node> list = new ArrayList<>();
        for(int i=0;i<a.length;i++)
            list.add(new Node(i,cnt[i]));
        Collections.sort(list,(n1,n2)->(n2.cnt-n1.cnt));
        for(Node node:list){
            if(node.cnt<answer)
                break;
            int res=0;
            for(int i=0;i<a.length-1;i++){
                if((a[i]==node.val || a[i+1]==node.val) && a[i]!=a[i+1]){
                    res+=2;
                    i++;
                }
            }
            answer = Math.max(answer, res);
        }
        return answer;
    }
}