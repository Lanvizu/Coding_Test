import java.util.*;
import java.io.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> result = new ArrayList<>();
        String[] nums = dartResult.split("[^0-9]+");
        String[] ops = dartResult.split("[0-9]+");
        for(int i=0; i<nums.length; i++){
            result.add(Integer.parseInt(nums[i]));
            for(char o:ops[i+1].toCharArray()){
                if(o=='S'){
                    result.set(i, (int)Math.pow(result.get(i),1));
                }else if(o=='D'){
                    result.set(i, (int)Math.pow(result.get(i),2));
                }else if(o=='T'){
                    result.set(i, (int)Math.pow(result.get(i),3));
                }else if(o=='*'){
                    if(i>0){
                        result.set(i-1, result.get(i-1)*2);
                    }
                    result.set(i, result.get(i)*2);
                }else if(o=='#'){
                    result.set(i, result.get(i)*(-1));
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            answer+=result.get(i);
        }
        
        return answer;
    }
}