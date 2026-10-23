package week1.p2;

import java.util.*;

class Solution {
    public int solution(String name) {
        char[] c = name.toCharArray();
        int len = c.length;
        int answer = 0;

        for(int i=0; i<len; i++){
            int k = c[i] - 'A';
            answer+=Math.min(k,26-k);
        }

        int move = len - 1;
        for (int i = 0; i < len; i++) {
            int next_i = i + 1;
            while (next_i < len && c[next_i] == 'A') {
                next_i++;
            }
            move = Math.min(move,Math.min(i * 2 + len - next_i,(len - next_i) * 2 + i));
        }
        answer+=move;

        return answer;
    }
}