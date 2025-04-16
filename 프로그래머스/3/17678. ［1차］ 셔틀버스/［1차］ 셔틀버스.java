import java.util.*;
import java.time.*;
import java.time.format.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Queue<String> q = new ArrayDeque<>();
        Arrays.sort(timetable);
        for(String s:timetable){
            q.add(s);
        }
        LocalTime time = LocalTime.parse("09:00", formatter);
        for(int i=0; i<n-1; i++){
            int total = 0;
            while(!q.isEmpty() && total < m){
                LocalTime next = LocalTime.parse(q.peek(), formatter);
                if(next.compareTo(time) <= 0){
                    q.poll();
                    total ++;
                }else{
                    break;
                }
            }
            time = time.plusMinutes(t);
        }
        
        if(q.size() < m){
            answer = time.toString();
        }else{
            int total = 0;
            while(!q.isEmpty() && total < m-1){
                LocalTime next = LocalTime.parse(q.peek(), formatter);
                if(next.compareTo(time) <= 0){
                    String now = q.poll();
                    total ++;
                }else{
                    break;
                }
            }
            if(q.isEmpty()){
                answer = time.toString();
            }else{
                LocalTime next = LocalTime.parse(q.peek(), formatter);
                if(next.compareTo(time) <= 0){
                    answer = next.minusMinutes(1).toString();
                }else{
                    answer = time.toString();
                }
            }
        }
        return answer;
    }
}