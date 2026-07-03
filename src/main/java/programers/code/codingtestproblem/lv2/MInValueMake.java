package programers.code.codingtestproblem.lv2;

import java.util.*;

public class MInValueMake {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Integer[] ASort = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] BSort = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(ASort); // 1 2 4
        Arrays.sort(BSort, (a, b) -> b-a); // 5 4 4

        for(int i=0;i<A.length;i++) {
            answer = answer + (ASort[i]*BSort[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        MInValueMake T = new MInValueMake();
        System.out.println(T.solution(new int[]{1,4,2}, new int[]{5,4,4}));
        System.out.println(T.solution(new int[]{1,2}, new int[]{3,4}));
    }
}
