package org.example.sortandthink.takecard;

import java.util.*;

public class TakeCardPractice {
    public int solution(int[] nums, int k){
        int answer = 0;
        int n = nums.length/2;
        Integer[] sorted = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Integer[] diff = new Integer[n];
        Arrays.sort(sorted, (a,b)->b-a); // 내림차순
        for(int i=0;i<n;i++) {
            answer += sorted[i*2+1]; // 현수합
            diff[i] = sorted[i*2] - sorted[i*2+1]; // 영희와 현수 합의 차이
        }
        Arrays.sort(diff, (a,b)->b-a); // 합 차이가 높은순으로 내림차순
        for(int i=0;i<k;i++) {
            answer += diff[i];
        }

        return answer;
    }

    public static void main(String[] args){
        TakeCardPractice T = new TakeCardPractice();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}
