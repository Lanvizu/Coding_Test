import java.util.*;
import java.util.Comparator;

class Solution {
    static int count = 0;
    static List<Integer> list = new ArrayList<>();

//    dfs를 사용하는 방식
    public static void dfs(int[][] dungeons, int k, boolean[] visited, int count) {
        for (int j = 0; j < dungeons.length; j++) {
//            방문하지 않았을 경우 모든 경우의 수 count
            if (!visited[j] && k >= dungeons[j][0]) {
                visited[j] = true;
                dfs(dungeons, k - dungeons[j][1], visited, count + 1);
//                다시 방분 false 처리
                visited[j] = false;
            }
        }
//        list로 나열한 다음 가장 큰 값 출력
        list.add(count);
    }
    

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        dfs(dungeons, k, visited, count);
        list.sort(Comparator.reverseOrder());
        return list.get(0);
    }
}