package org.example.greedy.sprinkler;

import java.util.*;

public class Sprinkler {
    public int solution(int n, int[] nums){
        int answer = 0;
        int[][] line = new int[nums.length+1][2];
        for(int i=0; i<=n; i++) { // 스프링쿨러가 n+1개 설치 되어있음
            line[i][0] = Math.max(0,i-nums[i]); // i번 스프링쿨러가 물을 뿌릴 수 있는 시작 지점 -> 음수에는 잔디가 없음
            line[i][1] = Math.min(n,i+nums[i]); // i번 스프링쿨러가 물을 뿌릴 수 있는 끝 지점 -> 잔디는 n까지만 있음
        }
        Arrays.sort(line, (a, b) -> a[0]-b[0]); // 시작값으로 정렬
        int start = 0,end = 0,i = 0;
        while(i < line.length) {
            while(i < line.length && line[i][0] <= start) { // i번 스프링쿨러가 뿌릴수 있는 최대 지점
                end = Math.max(end, line[i][1]);
                i++;
            }
            answer++;
            if(end==n) return answer;
            if(start==end) return -1; // 더 이상 진행 불가...
            start = end; // i번 스프링쿨러가 뿌린 끝지점부터 새롭게 커버하기 위해....
        }

        return answer;
    }

    public static void main(String[] args){
        Sprinkler T = new Sprinkler();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}

