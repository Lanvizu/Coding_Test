import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = change(m);
        int time = 0;
        for(String a:musicinfos){
            String[] infos = a.split(",");
            
            int start = (Integer.parseInt(infos[0].substring(0,2)) * 60)
                + Integer.parseInt(infos[0].substring(3));
                
            int end = (Integer.parseInt(infos[1].substring(0,2)) * 60)
                + Integer.parseInt(infos[1].substring(3));
            
            int t = end - start;
            
            if(t > time){
                String info = change(infos[3]);
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < t; i++) {
                    sb.append(info.charAt(i % (info.length())));
                }
                if (sb.toString().indexOf(m) >= 0) {
                    answer = infos[2];
                    time = t;
                }
            }
        }
        
        return answer;
    }
    
    public String change(String m) {

        m = m.replaceAll("C#", "U");
        m = m.replaceAll("D#", "V");
        m = m.replaceAll("F#", "W");
        m = m.replaceAll("G#", "X");
        m = m.replaceAll("A#", "Y");
        m = m.replaceAll("B#", "Z");

        return m;
    }
}