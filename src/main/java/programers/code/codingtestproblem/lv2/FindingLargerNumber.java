package programers.code.codingtestproblem.lv2;

import java.util.*;

public class FindingLargerNumber {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<numbers.length;i++) {
            while(!stack.isEmpty() && numbers[stack.peek()]< numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i); // 인덱스 저장
        }

        return answer;
    }

    public static void main(String[] args) {
         FindingLargerNumber T = new FindingLargerNumber();
        System.out.println(Arrays.toString(T.solution(new int[]{2, 3, 3, 5})));
//        System.out.println(Arrays.toString(T.solution(new int[]{9, 1, 5, 3, 6, 2})));
    }
}
