import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains(nums[i])) {
                hashSet.add(nums[i]);
            }
        }
        if (nums.length / 2 <= hashSet.size()) {
            answer = nums.length/2;
        } else {
            answer = hashSet.size();
        }
        return answer;
    }
}