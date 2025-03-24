import java.util.*;
import java.io.*;
class Solution {
    
    static HashSet<String> hs = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        Boolean[] visited = new Boolean[user_id.length];
        for(int i=0; i<user_id.length; i++){
            visited[i] = false;
        }
        dfs(user_id, banned_id, 0, visited);
        int answer = hs.size();
        
        return answer;
    }
    
    public void dfs(String[] user_id, 
                    String[] banned_id, 
                    int now, 
                    Boolean[] visited){
        
        if(now >= banned_id.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<visited.length;i++){
                if(visited[i]){
                    sb.append(i);
                }
            }
            hs.add(sb.toString());
            return;
        }
        for(int i=0; i<user_id.length; i++){
            if (visited[i]){
                continue;
            }
            if(check(user_id[i], banned_id[now])){
                visited[i] = true;
                dfs(user_id, banned_id, now+1, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(String user, String banned){
        String[] a = user.split("");
        String[] b = banned.split("");

        if (a.length != b.length){
            return false;
        }else{
            for (int i=0; i<a.length; i++){
                if(b[i].equals("*")){
                    continue;
                }else{
                    if(!a[i].equals(b[i])){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}