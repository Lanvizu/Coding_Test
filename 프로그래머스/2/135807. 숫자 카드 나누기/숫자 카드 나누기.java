import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        List<Integer> numA = calc1(arrayA);
        List<Integer> numB = calc1(arrayB);
        calc2(numA, arrayB);
        calc2(numB, arrayA);
        
        return answer;
    }
    
    // num으로 arr 전체 나눠지지 않는 경우 계산
    public void calc2(List<Integer> num, int[] arr){
        // 1만 있는 경우 불가능
        if(num.size() <= 1) return;
        for(int i = 0; i < arr.length; i++){
            int now = arr[i];
            int j = 0;
            while(true){
                if(num.size() <= j) break;
                int target = num.get(j);
                if(now % target == 0){
                    num.remove(j);
                    continue;
                }
                j++;
            }
        }
        if(num.size() > 0){
            answer = Math.max(num.get(0), answer);
        }
    }
    
    // arr 최소 수의 약수로 arr 전체에 대한 약수 리스트
    public List<Integer> calc1(int[] arr){
        List<Integer> num = findNum(arr[0]);
        for(int i=1; i<arr.length; i++){
            int now = arr[i];
            int j = 0;
            while(true){
                if(j >= num.size() - 1) break;
                int tt = num.get(j);
                if(now % tt != 0){
                    num.remove(j);
                    continue;
                }
                j++;
            }
        }
        return num;
    }
    
    // target의 약수 리스트 반환
    public List<Integer> findNum(int target){
        List<Integer> result = new ArrayList<>();
        for(int i = target; i > 0; i--){
            if(target % i == 0){
                result.add(i);
            }
        }
        return result;
    }
}