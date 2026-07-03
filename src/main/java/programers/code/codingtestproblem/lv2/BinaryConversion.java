package programers.code.codingtestproblem.lv2;

import java.util.Arrays;

public class BinaryConversion {

    public int[] solution(String s) {
        int[] answer = {};
        int cnt = 0;
        int zeros = 0;
        while(!s.equals("1")) {
            int zeroCnt = 0;
            for(char c : s.toCharArray()) if(c == '0') zeroCnt++; // 0개수 카운트
            zeros += zeroCnt; // 제거한 0의 개수

            int ones = s.length() - zeroCnt; // 0제거후 길이

            s = Integer.toBinaryString(ones); // 1의 개수를 이진수로

            cnt++;
        }

        return new int[]{cnt, zeros};
    }

    public static void main(String[] args) {
        BinaryConversion T = new BinaryConversion();
        System.out.println(Arrays.toString(T.solution("110010101001")));
        System.out.println(Arrays.toString(T.solution("01110")));
        System.out.println(Arrays.toString(T.solution("1111111")));
    }
}
