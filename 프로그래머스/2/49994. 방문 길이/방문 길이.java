import java.util.*;

class Solution {
    HashMap<Character, int[]> hs = new HashMap<>();
    
    public int solution(String dirs) {
        int answer = 0;
        hs.put('U', new int[]{-1,0,0,1});
        hs.put('D', new int[]{1,0,1,0});
        hs.put('R', new int[]{0,1,2,3});
        hs.put('L', new int[]{0,-1,3,2});
        boolean[][][] visited = new boolean[11][11][4];
        int[] now = {5,5};
        for(char dir:dirs.toCharArray()){
            int[] go = hs.get(dir);
            int nx = now[0] + go[0];
            int ny = now[1] + go[1];
            if(nx<0 || ny<0 || nx >10 || ny>10){
                continue;
            }
            if(!visited[now[0]][now[1]][go[2]] && !visited[nx][ny][go[3]]){
                visited[now[0]][now[1]][go[2]] = true;
                visited[nx][ny][go[3]] = true;
                answer ++;
            }
            now[0] = nx;
            now[1] = ny;
        }
        return answer;
    }
}
// 이미 움직인 길은 어떻게 처리할까 방문 처리
// 각 2차원 배열 내부에 4방향 방문 추가
// 1->2 로 가는 길과 2->1 로 오는 길 모두 체크해야함.