package programers.code.codingtestproblem.lv2;

import java.util.*;

public class TheLargestNumber {

    public String solution(int[] numbers) {
//        String answer = "";
        String[] strNums = new String[numbers.length];
        for(int i=0;i<strNums.length;i++) strNums[i] = String.valueOf(numbers[i]);
        Arrays.sort(strNums, (a, b) -> (b+a).compareTo(a+b));

        if(strNums[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : strNums) sb.append(s);

        return sb.toString();
    }

    public static void main(String[] args) {
        TheLargestNumber T = new TheLargestNumber();
        System.out.println(T.solution(new int[]{6, 10, 2}));
        System.out.println(T.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
