import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        int a = storey;
        List<Integer> st = new ArrayList<>();
        while (a > 0){
            int b = a % 10;
            a /= 10;
            st.add(b);
        }
        for(int i=0;i<st.size();i++){
            int now = st.get(i);
            if(now==5 && i < st.size()-1){
                if(st.get(i+1) >= 5){
                    st.set(i+1, st.get(i+1)+1);
                }
                answer += now;
            }
            else if(now>5){
                if(i==st.size()-1){
                    answer += 11-now;
                }else{
                    st.set(i+1, st.get(i+1)+1);
                    answer += 10-now;
                }
            }else{
                answer +=now;
            }
            // System.out.println(st);
            
        }
        return answer;
    }
}