import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hs = new HashMap<>();
        Queue<String[]> result = new ArrayDeque<>();
        for(String r:record){
            String[] n = r.split(" ");
            if(n[0].equals("Change")){
                hs.put(n[1], n[2]);
            }else if(n[0].equals("Enter")){
                hs.put(n[1], n[2]);
                result.add(new String[]{n[0],n[1]});
            }else{
                result.add(new String[]{n[0],n[1]});
            }
        }
        List<String> aa = new ArrayList<>();
        while(!result.isEmpty()){
            String[] r = result.poll();
            if(r[0].equals("Enter")){
                aa.add(hs.get(r[1])+"님이 들어왔습니다.");
            }else{
                aa.add(hs.get(r[1])+"님이 나갔습니다.");
            }
        }
        String[] answer = new String[aa.size()];
        for(int i=0; i<aa.size(); i++){
            answer[i] = aa.get(i);
        }
        return answer;
    }
}
// hashMap으로 아이디:이름 저장
// enter인지 leave인지만 저장해놓고
// 마지막에 이름으로 변경해서 저장