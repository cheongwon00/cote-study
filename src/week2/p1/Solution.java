package week2.p1;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //progresses:진도, speeds:속도
        List<Integer> list = new ArrayList<>();
        int temp=0;

        //각 기능들이 완료되는 날 계산
        for(int i=0; i<progresses.length; i++){
            temp = 100 - progresses[i];//temp에 남은 진행도
            if((temp%speeds[i])!=0){//진행 시간이 딱 안떨어지는 경우
                temp /= speeds[i];
                temp++;//1타임 더걸림
            }else{
                temp /= speeds[i];
            }
            list.add(temp);
        }

        int cnt=0;
        int prev=list.get(0);
        List<Integer> ans = new ArrayList<>();

        //이전 날짜보다 작은애들 모두 정답으로
        for(int day : list){
            if(day <= prev){
                cnt++;
            }else{
                ans.add(cnt);
                cnt=1;
                prev=day;
            }
        }
        ans.add(cnt);

        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}