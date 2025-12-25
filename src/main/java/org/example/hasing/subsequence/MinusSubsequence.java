package org.example.hasing.subsequence;

import java.util.*;

public class MinusSubsequence {
    public int solution(int[] nums, int m){
        int answer = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1); // sum - m 이 0이 될 경우 생각하기
        for(int x : nums) {
            sum += x;
            if(map.containsKey(sum-m)) answer += map.get(sum-m);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return answer;
    }

    public static void main(String[] args){
        MinusSubsequence T = new MinusSubsequence();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
