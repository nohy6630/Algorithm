import java.util.*;

class Solution {
    String[] user_id, banned_id;
    Set<Set<String>> ansSet = new HashSet<>();   //순서와 상관없이 수의집합의 중복을 자동으로 제거하여 저장해야 함. Set은 원소의 equals함수를 기준으로 중복을 체크함 -> Set의 equals는 단순히 원소 갯수와 집합내 값을 기준으로 비교하도록 정의되있음.
    
    void dfs(int idx, Set<String> ids){  //banned_id 배열의 idx번째 id에 매칭될수있는 user_id를 찾아줌
        if(idx == banned_id.length){
            ansSet.add(new HashSet<>(ids)); //찾은 id들의 조합을 set에 넣어줌. -> 자동으로 중복 제거      그리고 깊은복사로 ids를 집합에 넣어줘야함.
            return;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(!ids.contains(user_id[i]) && user_id[i].matches(banned_id[idx]))
            {
                ids.add(user_id[i]);
                dfs(idx + 1, ids);   //다음 banned_id 매칭시켜주기
                ids.remove(user_id[i]);
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        for(int i=0; i<banned_id.length; i++)
            banned_id[i] = banned_id[i].replace('*', '.');  //id끼리 비교할때 정규식을 이용할 것이기 때문에 정규식 형식에 맞춘다.
        this.user_id = user_id;
        this.banned_id = banned_id;
        dfs(0, new HashSet<>());
        return ansSet.size();
    }
}