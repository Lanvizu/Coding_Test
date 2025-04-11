import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int ml = msg.length();
        List<Integer> result = new ArrayList<>();
        HashMap<String,Integer> hs = new HashMap<>();
        for(int i=1; i<27; i++){
            char a = (char)(64+i);
            String b = Character.toString(a);
            hs.put(b,i);
        }
        
        String[] msgs = msg.split("");
        int index = 27;
        for(int i=0; i<ml;){
            String target = msgs[i];
            while(i<ml-1){
                String next = msgs[i+1];
                if(hs.containsKey(target+next)){
                    target += next;
                    i++;
                }else{
                    hs.put(target+next, index++);
                    break;
                }
            }
            result.add(hs.get(target));
            i++;
        }
        System.out.println(result);
        // List를 int[]로 변경하기....
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
    
}
// K -> 11 / KA 등록
// A -> 1 / AK 등록
// KA ->27 / KAO 등록
// O -> 15
// HashMap으로 등록을 해야할까?
// 현재 + 다음 문자로 검색했을 때 안나오면 등록해버리고 종료
// 있는 경우에는 현재+다음 + 다다음으로 검색 후 없으면 등록