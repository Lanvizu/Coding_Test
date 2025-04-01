import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] ss = s.split("");
        if(ss.length % 2 == 0){
            Queue<String> q = new ArrayDeque<>();
            for(String st:ss){
                q.offer(st);
            }
            for(int i=0; i<ss.length; i++){
                if(calc(q)){
                    answer += 1;
                }
                String temp = q.poll();
                q.offer(temp);
            }
        }
        return answer;
    }
    public Boolean calc(Queue<String> q){
        Stack<String> st = new Stack<>();
        Boolean result = true;
        for(String t:q){
            if(t.equals("]")){
                if(st.empty() || !st.pop().equals("[")){
                    result = false;
                    break;
                }
            }else if(t.equals(")")){
                if(st.empty() || !st.pop().equals("(")){
                    result = false;
                    break;
                }
            }else if(t.equals("}")){
                if(st.empty() || !st.pop().equals("{")){
                    result = false;
                    break;
                }
            }else{
                st.push(t);
            }
        }
        if(!st.empty()){
            result = false;
        }
        return result;
    }
}