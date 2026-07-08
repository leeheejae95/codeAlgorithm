package programers.code.codingtestproblem.lv2;

import java.util.*;

public class NumberOfSumsOfContiguousSubarrays {

    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        HashSet<Integer> set = new HashSet<>();
        for(int len=1;len<=n;len++) { // 길이 1~n까지
            for(int i=0;i<n;i++) { // 0~n-1까지
                int sum = 0;
                for(int j=0;j<len;j++) {  // j<1 j<2
                    sum += elements[(i+j)%n];
                }
                set.add(sum);
            }
        }
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        NumberOfSumsOfContiguousSubarrays T = new NumberOfSumsOfContiguousSubarrays();
        System.out.println(T.solution(new int[]{7,9,1,1,4}));
    }
}
