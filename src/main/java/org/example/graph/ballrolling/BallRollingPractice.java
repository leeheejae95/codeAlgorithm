package org.example.graph.ballrolling;

import java.util.*;

public class BallRollingPractice {
    public int solution(int[][] board, int[] s, int[] e){
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[][] cost = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(cost[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        pq.offer(new int[]{s[0],s[1],0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            for(int k=0; k<4; k++) {
                int nx = cur[0];
                int ny = cur[1];
                int len = cur[2];
                while(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] !=1) {
                    nx += dx[k];
                    ny += dy[k];
                    len++;
                }
                nx-=dx[k];
                ny-=dy[k];
                len--;
                if(cost[nx][ny] > len) {
                    cost[nx][ny] = len;
                    pq.offer(new int[]{nx,ny, cost[nx][ny]});
                }
            }
        }
        if(cost[e[0]][e[1]] == Integer.MAX_VALUE) return -1;
        else return cost[e[0]][e[1]];

//        return answer;
    }
    public static void main(String[] args){
        BallRollingPractice T = new BallRollingPractice();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
