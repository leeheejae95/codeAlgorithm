package edu.code.fourth_st.practice;

import java.util.*;

public class CgvPractice {
    public int solution(int total, int[] vip) {
        Arrays.sort(vip);
        int[] dp = new int[total+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=total; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        // 1 1 2 3 5 8 13 21 34 55

        int ans = 1;
        int cur_index = 0;
        for(int x : vip) {
            int len = x-cur_index-1; // 4-0-1=3 , 7-4-1 = 2
            ans *= dp[len]; // 3 5
            cur_index = x; // 4
        }
        ans *= dp[total-cur_index]; // 9-7 = 2

        return ans;
    }
    public static void main(String[] args){
        CgvPractice T =  new CgvPractice();
        System.out.println(T.solution(9, new int[]{4,7}));
    }
}
