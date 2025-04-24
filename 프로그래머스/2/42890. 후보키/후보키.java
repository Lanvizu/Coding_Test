import java.util.*;
class Solution {
    List<List<Integer>> minimalKeys= new ArrayList<>();
    public int solution(String[][] relation) {
        int row = relation[0].length;
        int col = relation.length;
        int answer = 0;
        
        for(int i=1; i<=row; i++){
            
            List<List<Integer>> result = new ArrayList<>();
            comb(new ArrayList<>(),row, 0, i, result);
            //result = [[1, 2], [1, 3], [2, 3]]
            // relation[0~row][1] + relation[0~row][2] -> check 비교
            
            for(List<Integer> now:result){
                if(!isMinimal(now)) continue;
                //now = [1,2]
                List<String> target = new ArrayList<>();
                for(int a=0; a<col; a++){
                    String b = "";
                    for(Integer c:now){
                        b += " " + relation[a][c];
                    }
                    target.add(b);
                }
                if(check(target)){
                    minimalKeys.add(new ArrayList<>(now));
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public boolean isMinimal(List<Integer> candidate) {
        for (List<Integer> key : minimalKeys) {
            if (candidate.containsAll(key)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean check(List<String> ss){
        HashSet<String> hs = new HashSet<>();
        for(String s:ss){
            if(hs.contains(s)){
                return false;
            }else{
                hs.add(s);
            }
        }
        return true;
    }
    
    public void comb(List<Integer> current,int row, int start, int r, List<List<Integer>> result){
        if(r==0){
            result.add(new ArrayList<>(current));
            return;
        }else{
            for(int i=start; i<row; i++){
                current.add(i);
                comb(current, row, i+1, r-1, result);
                current.remove(current.size()-1);
            }
        }
    }
}