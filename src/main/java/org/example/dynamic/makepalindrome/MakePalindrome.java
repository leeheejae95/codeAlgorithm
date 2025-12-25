package org.example.dynamic.makepalindrome;

import java.util.*;

public class MakePalindrome {

    public int solution(int n, int[] nums) {
        int[][] dy = new int[n+1][n+1]; // i번째부터 j번째 까지의 부분수열을 팰린드롬을 만들기 위해 끼워 넣어야 할 수의 최소 개수.
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i; j++) {
                if(nums[j] == nums[j+i]) dy[j][j+i] = dy[j+1][j+i-1];
                else dy[j][j+i] = Math.min(dy[j+1][j+i], dy[j][j+i-1])+1;
            }
        }
        return dy[1][n];
    }

    public static void main(String[] args) {
        MakePalindrome T = new MakePalindrome();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n+1];
        for(int i=1; i<=n; i++) num[i] = scanner.nextInt();

        System.out.println(T.solution(n, num));
    }
}
