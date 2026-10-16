package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class MInValueMakePractice {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Integer[] ANums = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] BNums = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(ANums);
        Arrays.sort(BNums, (a, b) -> b-a);

        for(int i=0; i<A.length;i++) answer = answer + (ANums[i]*BNums[i]);

        return answer;
    }

    public static void main(String[] args) {
        MInValueMakePractice T = new MInValueMakePractice();
        System.out.println(T.solution(new int[]{1,4,2}, new int[]{5,4,4}));
        System.out.println(T.solution(new int[]{1,2}, new int[]{3,4}));
    }
}
