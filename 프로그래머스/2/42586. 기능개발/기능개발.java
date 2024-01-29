import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        ArrayList<Integer> list = new ArrayList<>();

        int t = 0;
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (progresses[i] + speeds[i] * t >= 100) {
                count++;
            } else {
                if (count > 0) {
                    list.add(count);
                }
                if ((100 - progresses[i] - (speeds[i] * t)) % speeds[i] != 0) {
                    t += (100 - progresses[i]- (speeds[i] * t)) / speeds[i] + 1;
                } else {
                    t += (100 - progresses[i] - (speeds[i] * t)) / speeds[i];
                }
                count = 1;
            }
            if (i == length - 1) {
                list.add(count);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}