package org.example.bfs.homemove;

import java.util.*;

public class HomeMovePractice {
    public int solution(int[] pool, int a, int b, int home) {
        int answer = 0;
        int[][] ch = new int[2][10001];
        for(int x : pool) {
            ch[0][x] = 1;
            ch[1][x] = 1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0}); // 0위치에서 시작
        ch[0][0] = 1;
        ch[1][0] = 1;
        int L = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0;i<len;i++) {
                int[] cur =  q.poll();
                if(cur[0] == home) return L;
                int x = cur[0] + a;
                if(x <= 10000 && ch[0][x] == 0) { // 앞으로 이동
                    ch[0][x] = 1;
                    q.offer(new int[] {x,0});
                }
                x = cur[0] - b;
                if(x >= 0 && ch[1][x]==0 && cur[1]==0) { // 뒤로 이동
                    ch[1][x] = 1;
                    q.offer(new int[] {x,1});
                }
            }
            L++;
        }


        return -1;
    }

    public static void main(String[] args){
        HomeMovePractice T = new HomeMovePractice();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
