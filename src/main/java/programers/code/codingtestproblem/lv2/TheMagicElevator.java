package programers.code.codingtestproblem.lv2;

import java.util.*;

public class TheMagicElevator {

    public int solution(int storey) {
        int answer = 0;
        while(storey>0) {
            int digit = storey % 10; // 현재자릿수
            if(digit<5) {
                answer += digit;
            } else if(digit>5) {
                answer += (10-digit); // 올리기
                storey += (10-digit); // 올림처리
            } else { // digit = 5
                // 다음 자릿수 보고 결정
                if((storey/10)%10>=5) {
                    answer += 5;
                    storey += 5;
                } else {
                    answer += 5;
                }
            }
            storey/=10;
        }

        return answer;
    }

    public static void main(String[] args) {
        TheMagicElevator T = new TheMagicElevator();
        System.out.println(T.solution(16));
        System.out.println(T.solution(2554));
    }
}
