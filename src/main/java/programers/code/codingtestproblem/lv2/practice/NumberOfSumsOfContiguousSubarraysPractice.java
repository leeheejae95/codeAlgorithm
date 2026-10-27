package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class NumberOfSumsOfContiguousSubarraysPractice {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        HashSet<Integer> set = new HashSet<>();
        for(int len=1;len<=n;len++) { // 1~n번째
            for(int i=0;i<n;i++) {
                int sum = 0;
                for(int j=0;j<len;j++) { // len 길이만큼
                    sum += elements[(i+j)%n];
                }
                set.add(sum);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        NumberOfSumsOfContiguousSubarraysPractice T = new NumberOfSumsOfContiguousSubarraysPractice();
        System.out.println(T.solution(new int[]{7,9,1,1,4}));
    }
}
