package programers.code.codingtestproblem.lv2.practice;

import java.util.Arrays;

public class CarpetPractice {

    public int[] solution(int brown, int yellow ) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int garo = 0;
        int sero = 0;
        for(int i=1;i<=total;i++) {
            garo = i;
            sero = total/garo;
            if(garo >= sero) {
                if((garo-2)*(sero-2)==yellow) {
                    answer[0] = garo;
                    answer[1] = sero;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CarpetPractice T = new CarpetPractice();
        System.out.println(Arrays.toString(T.solution(10,2)));
        System.out.println(Arrays.toString(T.solution(8,1)));
        System.out.println(Arrays.toString(T.solution(24,24)));
    }
}
