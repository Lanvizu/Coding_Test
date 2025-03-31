import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hs = new HashMap<>();
        
        for(int i=0; i<10; i++){
            hs.put(discount[i], hs.getOrDefault(discount[i], 0) + 1);
        }
        
        for(int i=10; i<discount.length; i++){
            if(calc(want, number, hs)){
                answer += 1;
            }
            String last = discount[i-10];
            hs.put(last, hs.get(last)-1);
            if(hs.get(last) == 0){
                hs.remove(last);
            }
            hs.put(discount[i], hs.getOrDefault(discount[i], 0) + 1);
            // System.out.println(hs);
        }
        for(int i=0; i<10; i++){
            if(calc(want, number, hs)){
                answer += 1;
            }
            String target = discount[discount.length-10+i];
            hs.put(target, hs.get(target)-1);
            if(hs.get(target) == 0){
                hs.remove(target);
            }
            // System.out.println(hs);
        }
        
        return answer;
    }
    
    // 10부터 discount 끝까지 돌면서 다음꺼 더하고 마지막꺼 빼는 거 작업
    // want와 number 조건 충족하면 answer ++
    
    // hs, want, number을 통해서 조건 충족하는지 판단하는 함수 생성
    
    public Boolean calc(String[] want, int[] number, HashMap<String, Integer> hs){
        for(int i=0; i<want.length; i++){
            String key = want[i];
            int value = number[i];
            if (hs.getOrDefault(key, 0) >= value){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    
}
// 치킨: 1, 사과: 3, 바나나: 2, 쌀: 2, 고기: 2
// HashMap 사용해서 키: 상품, 벨류: 개수
