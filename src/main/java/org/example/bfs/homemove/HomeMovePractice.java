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
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0,0}); // 현재위치, 앞으로 이동했는지 뒤로이동했는지 구분
        ch[0][0] = 1;
        ch[1][0] = 1;
        int L = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i=0;i<size;i++) {
                int[] cur = Q.poll();
                if(cur[0]==home) return L;
                int nx = cur[0] + a;
                if(nx<=10000 && ch[0][nx]==0) { // 앞으로 이동
                    ch[0][nx] = 1;
                    Q.offer(new int[]{nx,0});
                }
                nx = cur[0] - b;
                if(nx>=0 && ch[1][nx]==0 && cur[1]==0) { // 뒤로 이동하는데 웅덩이가 아니고, 뒤로이동한 적이 있으면 안됨
                    ch[1][nx] = 1;
                    Q.offer(new int[]{nx,1});
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
