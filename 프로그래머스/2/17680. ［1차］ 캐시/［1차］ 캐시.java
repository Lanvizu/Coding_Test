import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0){
            return cities.length * 5;
        }
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        for(String city:cities){
            city = city.toLowerCase();
            if(q.contains(city)){
                q.remove(city);
                q.offer(city);
                answer += 1;
            }else{
                if(q.size() >= cacheSize){
                    q.poll();
                }
                q.offer(city);
                answer += 5;
            }
        }
        return answer;
    }
}