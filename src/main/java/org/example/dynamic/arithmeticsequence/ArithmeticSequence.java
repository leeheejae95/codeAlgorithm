package org.example.dynamic.arithmeticsequence;

import java.util.*;

public class ArithmeticSequence {

    public int solution(int n, int[] nums) {
        int answer = 0;
        if(n == 1) return 1;
        int[][] dy = new int[n+1][n+1]; // i번째와 j번째가 마지막 두항인 등차수열의 최대 길이
        Arrays.sort(nums);
        for(int i=1; i<=n-1; i++) {
            for(int j=i+1; j<=n; j++) {
                dy[i][j] = 2;
                int pre = 2*nums[i]-nums[j];
                int k = 0;
                for(k=i; k>=1; k--) if(nums[k] == pre) break;
                dy[i][j] = Math.max(dy[i][j], dy[k][i]+1);
                answer = Math.max(answer, dy[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ArithmeticSequence T = new ArithmeticSequence();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n+1];
        for(int i=1; i<=n; i++) nums[i] = scanner.nextInt();

        System.out.println(T.solution(n,nums));
    }
}
