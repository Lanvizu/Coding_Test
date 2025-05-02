import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = calc(p);
        return answer;
    }
    
    public String calc(String t){
        if(t=="") return "";
        String x = "";
        char[] tt = t.toCharArray();
        int R = 0;
        int L = 0;
        List<Character> cc = new ArrayList<>();
        for(int i=0; i<tt.length; i++){
            char now = tt[i];
            if(now == '(') L++;
            else R++;
            if(L!=0 && R!=0 && L==R){
                String a = t.substring(0,i+1);
                String b = t.substring(i+1,t.length());
                if(check(a)){
                    x+=a;
                    x+=calc(b);
                    return x;
                }else{
                    x+="(";
                    x+=calc(b);
                    x+=")";
                    x+=transform(a); // 4-4
                    return x;
                }
            }
        }
        return x;
    }
    
    public String transform(String t){
        char[] tt = t.toCharArray();
        String a = "";
        for(int i=1; i< tt.length-1; i++){
            if(tt[i] == '(') a+=")";
            else a+= "(";
        }
        return a;
    }
    
    // 올바른 괄호 문자열 체크
    public boolean check(String t){
        char[] tt = t.toCharArray();
        if (tt[0] == ')') return false;
        Stack<Character> st = new Stack<>();
        for(char target:tt){
            if(target == '('){
                st.add(target);
            }else{
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}
// 문자열 w 를 균형 잡힌 문자열 두개로 분리 -> u는 결국 ( 의 개수와 ) 의 개수가 일치하는 처음
// u가 올바른 문자열이 아닌 경우 
// () / ))((()
// ))((() -> ))(( / ()
// ( -> (() -> (())
// ))(( -> )( -> ()
// (())()