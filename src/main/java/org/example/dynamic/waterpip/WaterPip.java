package org.example.dynamic.waterpip;

import java.util.Scanner;

// 백준 2073번
public class WaterPip {
    public static void main(String[] args){
        // dy[i] : i길이의 수도관을 만들었을때 최대 용량
        Scanner scanner = new Scanner(System.in);
        int D = scanner.nextInt(); // 7
        int P = scanner.nextInt(); // 6
        int[] dy = new int[D+1];
        for(int i=0; i<P; i++) {
            int L = scanner.nextInt(); // 4
            int C = scanner.nextInt(); // 5
            for(int j=D; j>L; j--) {
                if(dy[j-L] == 0) continue;
                dy[j] = Math.max(dy[j], Math.min(dy[j-L],C)); // 수도관 용량은 최솟값이 되야함
            }
            dy[L] = Math.max(dy[L],C); // 기존 길이의 용량이 기존에 있는 값보다 더 크면 교체
        }
        System.out.println(dy[D]);
    }
}
