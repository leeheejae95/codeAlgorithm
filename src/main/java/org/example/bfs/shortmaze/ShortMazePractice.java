package org.example.bfs.shortmaze;

import java.util.*;

public class ShortMazePractice {
    public int solution(int[][] board){
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[][] dist = new int[7][7];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            L++;
            for(int i=0; i<len; i++) {
                int[] x = q.poll();
                for(int k=0; k<4; k++) {
                    int nx = x[0] + dx[k];
                    int ny = x[1] + dy[k];
                    if(nx>=0 && nx<7 && ny>=0 && ny<7 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                        dist[nx][ny] = L;
                    }
                }
            }
        }

        if(dist[n-1][m-1] == 0) return -1;
        else return dist[n-1][m-1];
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
