package programers.code.codingtestproblem.lv2.practice;

import java.util.Arrays;

public class BinaryConversionPractice {

    public int[] solution(String s) {
//        int[] answer = {};
        int cnt = 0;
        int zeros = 0;
        while(!s.equals("1")) {
            int zero = 0;
            for(char c : s.toCharArray()) if(c == '0') zero++; // 0갯수
            zeros += zero;

            int ones = s.length() - zero;

            s = Integer.toBinaryString(ones);

            cnt++;
        }

        return new int[]{cnt, zeros};
    }

    public static void main(String[] args) {
        BinaryConversionPractice T = new BinaryConversionPractice();
        System.out.println(Arrays.toString(T.solution("110010101001")));
        System.out.println(Arrays.toString(T.solution("01110")));
        System.out.println(Arrays.toString(T.solution("1111111")));
    }
}
