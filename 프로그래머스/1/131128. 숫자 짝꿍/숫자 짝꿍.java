import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] xArray = new int[10];
        int[] yArray = new int[10];

        // X와 Y의 각각의 숫자가 몇번 나왔는지 판단
        for(String temp : X.split("")){
            int index = Integer.parseInt(temp);
            xArray[index]++;
        }

        for(String temp : Y.split("")){
            int index = Integer.parseInt(temp);
            yArray[index]++;
        }

        // 정답을 만들기 위한 배열에 적은 갯수 나온 값으로 대입
        int[] answerArray = new int[10];
        for(int i=0; i<10; i++){
            answerArray[i] = Math.min(xArray[i], yArray[i]);
        }

        //9에서부터 돌면서 i가 answerArray[i]번
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--){
            for(int j=0; j<answerArray[i]; j++){
                //answer += String.valueOf(i);
                sb.append(i);
            }
        }

        answer = sb.toString();
        // 조건 추가        
        if(answer.isEmpty()) answer = "-1";
        else if(answer.replace("0", "").isEmpty()) answer = "0";
        return answer;
    }
}