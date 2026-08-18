package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class TheLargestNumberPractice {

    public String solution(int[] numbers) {
        String answer = "";
        String[] numArr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++) numArr[i]= String.valueOf(numbers[i]);
        Arrays.sort(numArr,(a,b)-> (b+a).compareTo(a+b));

        if(numArr[0].equals("0")) return "0";
        for(String num : numArr) answer += num;

        return answer;
    }

    public static void main(String[] args) {
        TheLargestNumberPractice T = new TheLargestNumberPractice();
        System.out.println(T.solution(new int[]{6, 10, 2}));
        System.out.println(T.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
