package programers.code.codingtestproblem.lv2;

import java.util.Arrays;

public class NoMoreThanTwoDifferentBits {

    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();

        for(int i = 0; i< answer.length; i++){
            answer[i]++;
            answer[i] += (answer[i]^numbers[i])>>>2;
        }
        return answer;
    }

    public static void main(String[] args) {
        NoMoreThanTwoDifferentBits T = new NoMoreThanTwoDifferentBits();
        System.out.println(Arrays.toString(T.solution(new long[]{2,7})));
    }
}
