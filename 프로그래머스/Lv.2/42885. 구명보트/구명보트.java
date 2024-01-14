import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int length = people.length;
        Integer[] array = IntStream.of(people)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        int back = 0;
        for (int i = 0; i < length - back; i++) {
            int count = limit - array[i];
            if (count >= 40 && array[length - 1 - back] <= count) {
                array[length - 1 - back] = 0;
                back++;
            }
            array[i] = 0;
            answer++;
        }
        return answer;

        //  Arrays.sort(people);
        // int i = 0, j = people.length - 1;
        // for (; i < j; --j) {
        //     if (people[i] + people[j] <= limit)
        //         ++i;
        // }
        // return people.length - i;
    }
}
