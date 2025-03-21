import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] graph = new int[n+1];
        graph[0] = 1;
        for(int i:money){
            for(int j=i; j<n+1; j++){
                graph[j] += graph[j-i];
            }
        }
        answer = graph[n];
        return answer;
    }
}

    