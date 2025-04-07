import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        List<List<Integer>> al = new ArrayList<>();
        String[] ss = s.substring(2,s.length()-2).split("\\},\\{");
        for(String ns:ss){
            List<Integer> nums = new ArrayList<>();
            for(String num : ns.split(",")){
                nums.add(Integer.parseInt(num));
            }
            al.add(nums);
        }
        
        answer = al.stream().sorted(Comparator.comparingInt(List::size))
            .flatMap(List::stream)
            .distinct()
            .mapToInt(i -> i)
            .toArray();
        return answer;
    }
}
// 튜플들의 조합을 보고서 튜플 순서를 리턴해라
// 