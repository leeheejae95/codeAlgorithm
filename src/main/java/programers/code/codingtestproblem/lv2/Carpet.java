package programers.code.codingtestproblem.lv2;

import java.util.*;

public class Carpet {

    public int[] solution(int brown, int yellow ) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int garo = 0;
        int sero = 0;
        for(int i=1;i<=total;i++) {
            garo = i; // 4
            sero = total/garo; // 3
            if(garo >= sero) {
                if((garo-2)*(sero-2)==yellow) { // 2 * 1
                    answer[0] = garo;
                    answer[1] = sero;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Carpet T = new Carpet();
        System.out.println(Arrays.toString(T.solution(10,2)));
        System.out.println(Arrays.toString(T.solution(8,1)));
        System.out.println(Arrays.toString(T.solution(24,24)));
    }
}
