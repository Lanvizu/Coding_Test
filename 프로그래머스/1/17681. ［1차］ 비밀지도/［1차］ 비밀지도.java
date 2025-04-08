import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            String a = Integer.toBinaryString(arr1[i] | arr2[i]);
            while(a.length() < n){
                a = "0" + a;
            }
            StringBuilder sb = new StringBuilder();
            String[] aa = a.split("");
            for(int j=0; j<n; j++){
                if(aa[j].equals("1")){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}