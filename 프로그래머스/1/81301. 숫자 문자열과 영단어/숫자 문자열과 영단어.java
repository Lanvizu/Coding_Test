class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] ss = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        // 48~57
        for(int i=0; i<ss.length;){
            char n = ss[i];
            if(48 <= (int)n && (int)n <= 57){
                sb.append(n);
                i++;
            }else{
                if(n=='z'){
                    sb.append(0);
                    i+=4;
                }else if(n=='o'){
                    sb.append(1);
                    i+=3;
                }else if(n=='t'){
                    if(ss[i+1]=='w'){
                        sb.append(2);
                        i+=3;
                    }else{
                        sb.append(3);
                        i+=5;
                    }
                }else if(n=='f'){
                    if(ss[i+1]=='o'){
                        sb.append(4);
                        i+=4;
                    }else{
                        sb.append(5);
                        i+=4;
                    }
                }else if(n=='s'){
                    if(ss[i+1]=='i'){
                        sb.append(6);
                        i+=3;
                    }else{
                        sb.append(7);
                        i+=5;
                    }
                }else if(n=='e'){
                    sb.append(8);
                    i+=5;
                }else{
                    sb.append(9);
                    i+=4;
                }
            }
        }
        for(String sbs:sb.toString().split("")){
            answer *= 10;
            answer += Integer.parseInt(sbs);
        }
        
        return answer;
    }
}