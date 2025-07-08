import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        // 곡괭이로 가능한 라운드 가져오기
        List<int[]> result = getRound(picks, minerals);
        for(int[] rr: result){
            // now는 현재 곡괭이
            int now = -1;
            for(int i=0; i<3; i++){
                if(picks[i] == 0) continue;
                now = i;
                picks[i]--;
                break;
            }
            if(now == 0){
                answer += rr[0] + rr[1] + rr[2];
            }else if(now == 1){
                answer += rr[0]*5 + rr[1] + rr[2];
            }else{
                answer += rr[0]*25 + rr[1]*5 + rr[2];
            }
        }
        
        return answer;
    }
    
    public List<int[]> getRound(int[] picks, String[] minerals){
        int n = 0;
        int m = minerals.length;
        for(int p: picks){
            n += 5 * p;
        }
        // 곡괭이보다 광물이 더 긴 경우
        if(n < m){
            m = n;
        }
        List<int[]> result = new ArrayList<>();
        int[] arr = new int[3];
        for(int i=0; i<m; i++){
            if(i%5 == 0 && i != 0){
                result.add(arr);
                arr = new int[3];
            }
            if(minerals[i].equals("diamond")) {
                arr[0]++;
            } else if (minerals[i].equals("iron")) { 
                arr[1]++;
            } else {
                arr[2]++;
            }
        }
        result.add(arr);
        Collections.sort(result, (a,b) -> {
            if(a[0]==b[0]){
                return b[1] - a[1];
            }else{
                return b[0] - a[0];
            }
        });
        return result;
    }
}