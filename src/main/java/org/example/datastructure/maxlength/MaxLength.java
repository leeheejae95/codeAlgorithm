package org.example.datastructure.maxlength;

import java.util.*;

public class MaxLength {
    public int solution(int[] nums){
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        for(int x : set) {
            if(set.contains(x-1)) continue; // x라는 값이 존재 하면 연속 수열에 시작 지점이 안된다
            int cnt = 0;
            while(set.contains(x)) { // 시작 지점 수열
                cnt++; // 길이
                x++;
            }
            answer = Math.max(answer, cnt);
        }


        return answer;
    }

    public static void main(String[] args){
        MaxLength T = new MaxLength();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
