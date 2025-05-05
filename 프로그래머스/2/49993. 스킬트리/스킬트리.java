import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        char[] ss = skill.toCharArray();
        for(int i=0; i<ss.length; i++){
            hs.put(ss[i], i);
        }
        for(String now:skill_trees){
            char[] nn = now.toCharArray();
            int cnt = 0;
            boolean flag = true;
            for(char n:nn){
                if(hs.containsKey(n)){
                    Integer target = hs.get(n);
                    if(cnt != target){
                        flag = false;
                        break;
                    }
                    cnt++;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}
// skill 을 split 해서 hashMap으로 처리하자.
