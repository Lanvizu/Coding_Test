import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int l = elements.length;
        //수열길이 i, 시작점 j
        Set<Integer> hs = new HashSet<>();
            
        for(int i=1; i<l; i++){
            for(int j=0; j<l; j++){
                int result = 0;
                for(int k=j; k<i+j; k++){
                    if(k>l-1){
                        result += elements[k-l];
                    }else{
                        result += elements[k];
                    }
                }
                hs.add(result);
            }
        }
        hs.add(Arrays.stream(elements).sum());
        int answer = hs.size();
        return answer;
    }
}
// 7 9 1 1 4
// 79 91 11 14 47
// 791 911 114 147 479
// 7911 9114 1147 1479 4791
// 79114 91147