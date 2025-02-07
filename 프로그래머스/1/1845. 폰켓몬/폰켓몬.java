import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int nums_len = nums.length;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < nums_len; i++){
            hs.add(nums[i]);
        }
        int type = hs.size();
        System.out.println(type);
        if(type >= nums_len/2){
            answer = nums_len/2;
        }else{
            answer = type;
        }
        return answer;
    }
}