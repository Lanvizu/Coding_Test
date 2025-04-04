import java.util.*;
import java.io.*;
class Solution {
    int a;
    public int[] solution(String s) {
        int t = 0;
        a = 0;
        while(!s.equals("1")){
            String target = remove_0(s);
            String next = convert2(target);
            s = next;
            t++;
        }
        int[] answer = new int[]{t,a};
        
        return answer;
    }
    public String remove_0(String s){
        String[] sp = s.split("");
        StringBuilder sb = new StringBuilder();
        for(String i: sp){
            if(i.equals("1")){
                sb.append(i);
            }else{
                a ++;
            }
        }
        return sb.toString();
    }
    public String convert2(String target){
        int n = target.length();
        String next = Integer.toBinaryString(n);
        return next;
    }
}