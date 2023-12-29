import java.util.*;

class Solution {
    class Node{
        Map<Character, Node> children = new HashMap<>();
        boolean isEnd;
        Node parent;
        
        void insert(String word){
            Node cur = this;
            char[] arr = word.toCharArray();
            for(char c : arr){
                Node next = cur.children.get(c);
                if(next == null){
                    next = new Node();
                    cur.children.put(c, next);
                    next.parent = cur;
                }
                cur = next;
            }
            cur.isEnd = true;
        }
        
        int calSearchCnt(String word){
            int ret = word.length();
            Node cur = this;
            char[] arr = word.toCharArray();
            for(char c : arr)
                cur = cur.children.get(c);
            if(!cur.children.isEmpty())
                return ret;
            
            cur = cur.parent;
            while(cur != null){
                if(cur.isEnd || cur.children.size() > 1)
                    break;
                cur = cur.parent;
                ret--;
            }
            return ret;
        }
    }
    
    public int solution(String[] words) {
        int answer = 0;
        Node trie = new Node();
        for(String w : words)
            trie.insert(w);
        for(String w : words)
            answer += trie.calSearchCnt(w);
        return answer;
    }
}