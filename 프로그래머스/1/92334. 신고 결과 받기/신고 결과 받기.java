import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        String[] report2 = Arrays.stream(report).distinct().toArray(String[]::new);

        String[] result = new String[id_list.length];

        HashMap<String, StringBuilder> map = new HashMap<>();

        for (int i = 0; i < report2.length; i++) {
            String a = report2[i].split(" ")[1];
            String b = report2[i].split(" ")[0];

            if (map.containsKey(a)) {
                StringBuilder builder = map.get(a);
                builder.append(" ").append(b);
            } else {
                StringBuilder builder = new StringBuilder();
                map.put(a, builder.append(b));
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            hashMap.put(id_list[i], 0);
        }
        for (int i = 0; i < id_list.length; i++) {
            StringBuilder builder = map.get(id_list[i]);
            if (builder != null
                    && Arrays.stream(builder.toString().split(" ")).count() >= k) {
                for (String a : builder.toString().split(" ")) {
                    hashMap.merge(a, 1, Integer::sum);
                }
            }
        }
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = hashMap.get(id_list[i]);
        }
        return answer;

        // List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        // HashMap<String, Integer> count = new HashMap<>();
        // for (String s : list) {
        //     String target = s.split(" ")[1];
        //     count.put(target, count.getOrDefault(target, 0) + 1);
        // }

        // return Arrays.stream(id_list).map(_user -> {
        //     final String user = _user;
        //     List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
        //     return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        // }).mapToInt(Long::intValue).toArray();
    }
}
