import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0){
            answer = cities.length * 5;
        }else{
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
                if(q.size()>cacheSize){
                    q.poll();
                }
            }
        }
        return answer;
    }
}