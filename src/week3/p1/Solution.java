package week3.p1;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right =people.length-1;
        int answer = 0;

        while(left <= right){
            if(left == right){
                left++;
                right--;
                answer++;
                continue;
            }
            if((people[left]+people[right])<=limit){
                left++;
                right--;
                answer++;
                continue;
            }
            answer++;
            right--;
        }
        return answer;
    }
}