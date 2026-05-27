package org.example.hasing.subsequence;

import java.util.*;

public class MinusSubsequencePractice {
    public int solution(int[] nums, int m){
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        for(int x : nums) {
            sum += x; // 누적합
            if(map.containsKey(sum-m)) answer += map.get(sum-m); // 전체 누적합에서 5가되는합을 구하려고하는데 이전에 누적합을 빼면 구할 수 있는데 그 누적합이 맵에 있나??
            map.put(sum, map.getOrDefault(sum,0)+1); // 누적합을 키로 1씩증가
        }

        return answer;
    }

    public static void main(String[] args){
        MinusSubsequencePractice T = new MinusSubsequencePractice();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
