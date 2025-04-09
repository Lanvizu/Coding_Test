import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> l1 = change(str1);
        List<String> l2 = change(str2);
        int[] ab = calc(l1, l2);
        if(ab[1] == 0){
            answer = 65536;
        }else{
            answer = (int)(65536*ab[0]/ab[1]);
        }
        return answer;
    }
    
    public int[] calc(List<String> l1, List<String> l2){
        HashMap<String, Integer> hs1 = new HashMap<>();
        int a = 0;
        for(int i=0; i<l1.size(); i++){
            String tar = l1.get(i);
            hs1.put(tar, hs1.getOrDefault(tar, 0) + 1);
        }
        for(int i=0; i<l2.size(); i++){
            String tar = l2.get(i);
            if(hs1.containsKey(tar)){
                int val = hs1.get(tar);
                if(val < 2){
                    hs1.remove(tar);
                }else{
                    hs1.replace(tar, val-1);
                }
                a++;
            }
        }
        return new int[]{a, l1.size() + l2.size() - a};
    }
    
    public List<String> change(String input){
        char[] st = input.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i=0; i<input.length()-1; i++){
            char a = Character.toLowerCase(st[i]);
            char b = Character.toLowerCase(st[i+1]);
            if(!Character.isLetter(a) || !Character.isLetter(b)){
                continue;
            }
            result.add(""+a+b);
        }
        return result;
    }
}