package week4.p2;

class Solution {
    public int[] solution(int brown, int yellow) {

        // a + b = brown/2 +2
        // ab = yellow +2(a+b) -4
        int a_b = brown/2 + 2;
        int ab = yellow + 2*a_b -4;
        int[] answer = new int[2];

        for(int a=1; a<=(a_b/2); a++){
            int b = a_b-a;
            if((a*b)==ab){
                answer[0]=b;
                answer[1]=a;
            }
        }
        return answer;
    }
}