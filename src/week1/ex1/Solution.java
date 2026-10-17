package week1.ex1;

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String,List<Integer>> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for(String s : info){
            String[] tmp = s.split(" ");
            parse(map,tmp);
        }

        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        for(String q : query){
            String[] tmp = q.replaceAll(" and "," ").split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(tmp[0])
                    .append(tmp[1])
                    .append(tmp[2])
                    .append(tmp[3]);
            String key = sb.toString();
            List<Integer> scores = map.get(key);
            if(scores == null){
                answer.add(0);
                continue;
            }
            int left = 0;
            int right = scores.size() - 1;
            int target = Integer.parseInt(tmp[4]);
            while(left<=right){
                int mid = left + (right - left)/2;
                if(scores.get(mid) >= target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            answer.add(scores.size()-right-1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

    public void parse(Map<String,List<Integer>> map,String[] tmp){
        for(int i=0; i<16; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                if (((i >> j) & 1) == 0) {
                    sb.append("-");
                } else {
                    sb.append(tmp[j]);
                }
            }
            String key = sb.toString();
            List<Integer> list;
            if(!map.containsKey(key)){
                list = new ArrayList<>();
            }else{
                list = map.get(key);
            }
            int score = Integer.parseInt(tmp[4]);
            list.add(score);
            map.put(key,list);
        }
    }
}