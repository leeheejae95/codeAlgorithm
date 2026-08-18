package programers.code.codingtestproblem.lv2.practice;

import java.util.Arrays;

public class NoMoreThanTwoDifferentBitsPractice {

    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for(int i=0;i<answer.length;i++) {
            answer[i]++;
            answer[i] += (answer[i]^numbers[i]) >>>2;
        }

        return answer;
    }

    public static void main(String[] args) {
        NoMoreThanTwoDifferentBitsPractice T = new NoMoreThanTwoDifferentBitsPractice();
        System.out.println(Arrays.toString(T.solution(new long[]{2,7})));
    }
}
