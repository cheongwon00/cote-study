package week2.p2;

import java.util.*;

class Solution {
    int n;
    boolean[] visited;
    List<Integer> selected;
    List<List<Integer>> per;

    public int solution(String[] user_id, String[] banned_id) {
        n = user_id.length;
        int r = banned_id.length;
        visited = new boolean[n];
        selected = new ArrayList<>();
        per = new ArrayList<>();
        String[] banned_id_reg = new String[r];
        Set<Set<Integer>> result = new HashSet<>();

        dfs(r);//dfs+백트랙킹으로 순열 생성

        for(int i=0; i<r; i++){
            banned_id_reg[i] = banned_id[i].replace("*",".");
        }

        for(List<Integer> p : per){
            boolean flag = false;
            for(int i=0; i<r; i++){
                if (!user_id[p.get(i)].matches(banned_id_reg[i])) {
                    flag=true;
                    break;
                }
            }
            if(!flag){
                result.add(new HashSet<>(p));
            }
        }
        return result.size();
    }
    void dfs(int r){
        if(selected.size() == r){
            per.add(new ArrayList<>(selected));
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i] == true) continue;

            visited[i] = true;
            selected.add(i);

            dfs(r);

            selected.remove(selected.size()-1);
            visited[i] = false;
        }
    }
}