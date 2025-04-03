import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[] {1,1,1,1,1};
        
        for(int i=0; i<5; i++){
            char[][] graph = new char[5][5];
            Boolean flag = true;
            for(int j=0; j<5; j++){
                char[] target = places[i][j].toCharArray();
                graph[j] = target;
            }
            for(int a=0; a<5; a++){
                for(int b=0; b<5; b++){
                    if(graph[a][b] == 'P'){
                        flag = calc(a,b,graph);
                    }
                    if(!flag){
                        break;
                    }
                }
                if(!flag){
                    answer[i] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    public Boolean calc(int nx, int ny, char[][] graph){
        //1. 오른쪽 1칸, 아래 1칸 체크
        if((nx+1 < 5 && graph[nx+1][ny] == 'P') || 
          (ny+1 < 5 && graph[nx][ny+1] == 'P')){
            return false;
        }
        //2. 오른쪽 2칸, 아래 2칸 체크
        if((nx+2 < 5 && graph[nx+2][ny] == 'P' && graph[nx+1][ny] !='X') ||
          (ny+2 < 5 && graph[nx][ny+2] == 'P' && graph[nx][ny+1] !='X')){
            return false;
        }
        
        //3. 아래 대각선 2개 체크
        if((nx+1 < 5 && ny-1 >= 0 && graph[nx+1][ny-1] == 'P' && (graph[nx+1][ny] != 'X' || graph[nx][ny-1] != 'X')) || 
          nx+1 < 5 && ny+1 < 5 && graph[nx+1][ny+1] == 'P' && (graph[nx+1][ny] != 'X' || graph[nx][ny+1] != 'X')){
            return false;
        }
        
        return true;
        
    }
}

// 일단 P와 P 사이를 체크 해야한다.
// 예를들어 P X P -> 처음 P만 체크해도 된다.
// 아래만 체크? -> 2칸 내에 P 없으면 통과
// 순서대로 돌아가면서  경우의 수가 2개 -> 직선 거리 2칸 이내면 X 가 사이에 있는지 체크
// 대각선에 있는 경우 -> 둘 사이에 X가 2개 전부 있는지 체크
  //   P X X
  // X X X
  //   X
