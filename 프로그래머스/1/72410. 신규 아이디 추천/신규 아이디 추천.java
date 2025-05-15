import java.util.*;
class Solution {
    public String solution(String new_id) {
        String result = type12(new_id);
        result = type34(result);
        result = type567(result);
        return result;
    }
    
    public String type12(String a){
        StringBuilder sb = new StringBuilder();
        char[] charA = a.toCharArray();
        for(char A: charA){
            //1
            char cA = Character.toLowerCase(A);
            //2
            if((97 <= (int)cA  && (int)cA <= 122)
               || (48 <= (int)cA  && (int)cA <= 57)
               || cA == '-' || cA == '_' || cA == '.'){
                sb.append(cA);
            }
        }
        return sb.toString();
    }
    
    public String type34(String a){
        StringBuilder sb = new StringBuilder();
        char[] charA = a.toCharArray();
        int ls = charA.length;
        //4
        int st = 0;
        int ed = ls-1;
        for(int i=0; i<ls; i++){
            if(charA[i] != '.'){
                st = i;
                break;
            }
        }
        for(int i=ls-1; i>=0; i--){
            if(charA[i] != '.'){
                ed = i;
                break;
            }
        }
        if(charA[st] == '.' || charA[ed] == '.'){
            return "";
        }
        //3
        int cnt = 0;
        for(int i=st; i<ed+1; i++){
            char A = charA[i];
            if(A == '.'){
                if(cnt > 0){
                    continue;
                }
                cnt++;
            }else cnt = 0;
            sb.append(A);
        }
        return sb.toString();
    }
    
    public String type567(String a){
        //5
        if(a == ""){
            a = "a";
        }
        //6
        if(a.length() > 15){
            a = a.substring(0,15);
            if(a.charAt(14) == '.'){
                for(int i=13; i>=0; i--){
                    if(a.charAt(i) != '.'){
                        a = a.substring(0,i+1);
                        break;
                    }
                }
            }
        }
        //7
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        while(sb.length() < 3){
            char endWord = a.charAt(a.length()-1);
            sb.append(endWord);
        }
        
        return sb.toString();
    }

}