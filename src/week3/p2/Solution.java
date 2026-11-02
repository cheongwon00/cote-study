package week3.p2;

import java.util.*;

class Solution {
    record State(int num, int cnt){}
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State(0,0));
        while(!stack.isEmpty()){
            State cur = stack.pop();
            if((cur.cnt()==numbers.length)&&(cur.num() == target)){
                answer++;
                continue;
            }
            if(cur.cnt()==numbers.length){
                continue;
            }
            stack.push(new State(cur.num()+numbers[cur.cnt()], cur.cnt()+1));
            stack.push(new State(cur.num()-numbers[cur.cnt()], cur.cnt()+1));
        }
        return answer;
    }
}