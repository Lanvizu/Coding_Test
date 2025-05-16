import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        // for 문 -> 각 스테이지 별 사람 수 확인 -> HashMap
        // 각 스테이지 별 실패율 계산 -> 우선순위 큐
        // -> 내림 차순으로 answer 출력
        
        HashMap<Integer, Integer> hs = new HashMap<>();
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a[0]==b[0]){
                    return Double.compare(a[1], b[1]);
                }
                return Double.compare(a[0], b[0]);
            }
        );
        
        for(int s:stages){
            int now = hs.getOrDefault(s,0);
            hs.put(s, now+1);
        }
        int total = stages.length;
        for(int i=1; i<=N; i++){
            if(total <= 0){
                pq.offer(new double[] {0.0, (double)i});
                continue;
            }
            int now = hs.getOrDefault(i, 0);
            double result = (double)now/(double)total;
            pq.offer(new double[] {-result, (double)i});
            total -= now;
        }
        
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            double[] a = pq.poll();
            answer[i] = (int)a[1];
        }
        return answer;
    }
}

// 20만이므로 for문 단 한번으로 처리해야함.
// 1 -> 1/8 / 2->2번 사람들(3)/1번 사람 빼고 전체(8-1)7 / 3-> 3번 사람들(2)/이전 전체 - 2번 사람들(7-3) 