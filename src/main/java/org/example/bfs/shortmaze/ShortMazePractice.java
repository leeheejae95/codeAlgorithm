package org.example.bfs.shortmaze;

import java.util.*;

public class ShortMazePractice {
    public int solution(int[][] board){
        int answer = 0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[][] dist = new int[7][7];
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0,0});
        int L=0;
        while(!Q.isEmpty()) {
            L++;
            int size = Q.size();
            for(int i=0;i<size;i++) {
                int[] x = Q.poll();
                for(int k=0;k<4;k++) {
                    int nx = dx[k] + x[0];
                    int ny = dy[k] + x[1];
                    if(nx>=0 && nx<7 && ny>=0 && ny<7 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        Q.offer(new int[]{nx,ny});
                        dist[nx][ny] = L; // 거리누적
                    }
                }
            }
        }

        if(dist[6][6] == 0) return -1;
        else return dist[6][6];

//        return answer;
    }

    public static void main(String[] args){
        ShortMazePractice T = new ShortMazePractice();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}
