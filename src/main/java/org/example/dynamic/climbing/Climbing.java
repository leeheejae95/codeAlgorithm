package org.example.dynamic.climbing;

import java.util.*;

public class Climbing {
    public int solution(int n, int[] score) {
        int[] dy = new int[n+1]; // i번 계단까지 올랐을 때 얻을 수 있는 최대점수
        dy[1] = score[1];
        dy[2] = score[1]+score[2];
        for(int i=3; i<=n; i++) {
            dy[i] = Math.max(dy[i-2]+score[i], dy[i-3]+score[i-1]+score[i]);
        }
        return dy[n];
    }
    public static void main(String[] args) {
        Climbing T = new Climbing();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] score = new int[n+1];
        for(int i=1; i<=n; i++) {
            score[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n,score));
    }
}
