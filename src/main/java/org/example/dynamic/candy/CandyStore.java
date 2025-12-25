package org.example.dynamic.candy;

import java.util.*;
// LIS / 냅색문제.
// 동전 1 동전 2 평범한 배낭 문제 풀어보기
public class CandyStore {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int n = scanner.nextInt(); // 2
            int m = (int)Math.round(scanner.nextDouble()*100); // 8.00
            if(n==0 && m==0) break;
            int[] dy = new int[m+1];
            for(int i=0; i<n; i++) {
                int c = scanner.nextInt(); // 700,199
                int p = (int)Math.round(scanner.nextDouble()*100); // 7.00,2.00
                for(int j=p; j<=m; j++) {
                    dy[j] = Math.max(dy[j], dy[j-p]+c);
                }
            }
            System.out.println(dy[m]);
        }
    }
}
