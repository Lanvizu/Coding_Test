import java.util.*;
class Solution {
    int cnt = 1;
    public int[] solution(int n) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> graph1 = new ArrayList<>();
        List<List<Integer>> graph2 = new ArrayList<>();
        int st = 0;
        int ed = n-1;
        for(int i=0; i<n; i++){
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }
        for(int i=n; i>0;){
            type1(graph1, st, i--);
            type2(graph1, ed--, i--);
            type3(graph2, ed, i--);
            st+=2;
        }
        for(int i=0; i<n; i++){
            for(int now : graph1.get(i)){
                result.add(now);
            }
            for(int now : graph2.get(i)){
                result.add(now);
            }
        }
        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    public void type1(List<List<Integer>> graph1, int a, int b){
        for(int i=a; i<a+b; i++){
            graph1.get(i).add(cnt++);
        }
    }
    
    public void type2(List<List<Integer>> graph1, int a, int b){
        for(int i=0; i<b; i++){
            graph1.get(a).add(cnt++);
        }
    }
    
    public void type3(List<List<Integer>> graph2, int a, int b){
        for(int i=a; i>a-b; i--){
            graph2.get(i).add(0,cnt++);
        }
    }
}
// 방향은 3가지 1. 하 방향 2. 우 방향 3. 상 방향
// n=6 / 1. 1~6(4) / 2. 7 ~ 11(5) / 3. 12~15(4) / 4. 16~18(3) / 5. 19 20 / 6. 21
// 문제는 위 방향 진행 시 제일 마지막 행으로 들어가야함.
// 위 방향 배열을 따로 만들까?
