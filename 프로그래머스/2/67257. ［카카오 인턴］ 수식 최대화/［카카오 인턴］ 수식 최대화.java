import java.io.*;
import java.util.*;

class Solution {
    String[] pri = {"*+-","*-+","+-*","+*-","-*+","-+*"};
    public long solution(String expression){
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int l = expression.length();
        
        for(int i=0; i<l; ){
            int j = i;
            while(j < l && Character.isDigit(expression.charAt(j))){
                j++;
            }
            if(j != l ){
                ops.add(expression.charAt(j));
            }
            nums.add(Long.valueOf(expression.substring(i, j)));
            i = j+1;
        }
        
        long max = 0;
        for(String p: pri){
            List<Long> now_nums = new ArrayList<>(nums);
            List<Character> now_ops = new ArrayList<>(ops);
            for(char c:p.toCharArray()){
                for(int i=0; i<now_ops.size();){
                    char op = now_ops.get(i);
                    if(op != c){
                        i++; continue;
                    }
                    if(op == '*'){
                        now_nums.set(i, now_nums.get(i) * now_nums.get(i+1));
                    }else if(op == '-'){
                        now_nums.set(i, now_nums.get(i) - now_nums.get(i+1));
                    }else if(op == '+'){
                        now_nums.set(i, now_nums.get(i) + now_nums.get(i+1));
                    }
                    
                    now_nums.remove(i+1);
                    now_ops.remove(i);
                }
            }
            max = Math.max(max, Math.abs(now_nums.get(0)));
        }
        return max;
    }
}