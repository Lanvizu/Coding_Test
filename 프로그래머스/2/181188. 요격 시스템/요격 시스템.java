import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a,b) -> b[0] - a[0]);
        List<int[]> arr = new ArrayList<>();
        for(int[] tt: targets){
            boolean check = false;
            for(int i=0; i<arr.size(); i++){
                int[] ms = arr.get(i);
                if(ms[1] <= tt[0] || tt[1] <= ms[0]) continue;
                arr.set(i, new int[] {Math.max(ms[0], tt[0]), Math.min(ms[1], tt[1])});
                check = true;
                break;
            }
            if(!check) arr.add(tt);
            // for(int i=0; i<arr.size(); i++){
            //     System.out.println(Arrays.toString(arr.get(i)));
            // }
            // System.out.println();
        }
        return arr.size();
    }
}
// (4,5) 다음 4,8이 들어온 경우 중복되는데 최소값이 키
// (10,14) (11,13)-> 키 값
// (5,12) 11,13 쪽으로 들어감
// 3,7 -> (4,5)로 들어감
// 1,4 -> 범위에 없어서 키 값으로 업데이트
// 어떻게 저장해야할까? -> (4,5) 이차원 배열에 a[4] = 5 이렇게 저장하면?
// 아니면 PQ 사용해서 {4,5} 이렇게?