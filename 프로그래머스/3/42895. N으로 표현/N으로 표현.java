import java.util.HashMap;
import java.util.Map;
class Solution {
    private Map<Integer, Integer> initMap(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = N, digit = 1; i <= 1111111111; i = i * 10 + N, digit++) {
            map.put(i, digit);
        }

        return map;
    }

    private void a(int N, int current, int cnt, Map<Integer, Integer> map) {
        if (cnt > 8 || (current == 0 && cnt > 0)) {
            return;
        }
        map.put(current, Math.min(map.getOrDefault(current, cnt), cnt));

        for (int i = N, digit = 1; i <= 1111111111; i = i * 10 + N, digit++) {
            a(N, current + i, cnt + digit, map);
            a(N, current - i, cnt + digit, map);
            a(N, current / i, cnt + digit, map);
            a(N, current * i, cnt + digit, map);
        }
    }

    public int solution(int N, int number) {
        Map<Integer, Integer> map = initMap(N);
        a(N, 0, 0, map);
        return map.getOrDefault(number, -1);
    }
}