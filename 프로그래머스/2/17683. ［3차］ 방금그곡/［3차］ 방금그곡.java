import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        HashMap<Integer, String> hs = new HashMap<>();
        for(String a:musicinfos){
            String[] infos = a.split(",");
            char[] b = infos[3].toCharArray();
            int ml = b.length;
            List<String> music = new ArrayList<>();
            for(int i=0; i<ml-1;){
                if(b[i+1] != '#'){
                    music.add(""+b[i]);
                    i++;
                }else{
                    music.add(""+b[i]+b[i+1]);
                    i+=2;
                }
            }
            if(b[ml-1] != '#'){
                music.add(""+b[ml-1]);
            }
            
            String[] N1 = infos[0].split(":");
            String[] N2 = infos[1].split(":");
            int[] n1 = new int[2];
            int[] n2 = new int[2];
            for(int i=0; i<2; i++){
                n1[i] = Integer.parseInt(N1[i]);
                n2[i] = Integer.parseInt(N2[i]);
            }
            int time = n2[1] - n1[1];
            if(time < 0){
                time += (n2[0] - n1[0] - 1)*60 +60;
            }else{
                time += (n2[0] - n1[0]) *60;
            }
            
            String result = "";
            for(int i=0; i<time; i++){
                result += music.get(i % music.size());
            }
            for(int i=0; i<result.length()-m.length()+1; i++){
                // 마지막 다음 글자가 #인 경우는 제외해야함
                if(i<result.length()-m.length()
                   &&result.charAt(i+m.length()) == '#'){
                    continue;
                }
                String target = result.substring(i,i+m.length());
                if(m.equals(target) && !hs.containsKey(time)){
                    hs.put(time, infos[2]);
                    break;
                }
            }
        }
        if(hs.isEmpty()){
            return "(None)";
        }
        Set<Integer> hsKeys = hs.keySet();
        List<Integer> hsKeys_sort = new ArrayList<>(hsKeys);
        Collections.sort(hsKeys_sort);
        return hs.get(hsKeys_sort.get(hsKeys_sort.size()-1));
    }
}
// 어떻게 접근해야할까
// 시간별로 반복하여 일단 작성 -> CDEFGABCDEFGAB -> ABCDEFG(m)이 존재하는지 체크?
// 저장해놓고 마지막에 일치하는 곡 끼리 비교해야함 (라디오의 시간도 같이 저장)