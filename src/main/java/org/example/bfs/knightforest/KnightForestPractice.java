package org.example.bfs.knightforest;

import java.util.*;

public class KnightForestPractice {
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int r = board.length;
        int c = board[0].length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[][] cost = new int[r][c];
        Queue<int[]> Q = new LinkedList<>();
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(board[i][j]==2 || board[i][j]==3) {
                    Q.offer(new int[]{i,j});
                    int[][] ch = new int[r][c];
                    ch[i][j] = 1;
                    int L = 0;
                    while(!Q.isEmpty()) {
                        L++;
                        int size = Q.size();
                        for(int m=0;m<size;m++) {
                            int[] cur = Q.poll();
                            for(int k=0;k<4;k++) {
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if(nx>=0 && nx<r && ny>=0 && ny<c && board[nx][ny] != 1 && ch[nx][ny] == 0) {
                                    if(ch[nx][ny]==0) {
                                        ch[nx][ny] = 1;
                                        Q.offer(new int[]{nx,ny});
                                        cost[nx][ny] += L;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(board[i][j]==4 && cost[i][j]>0) {
                    answer = Math.min(answer, cost[i][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        KnightForestPractice T = new KnightForestPractice();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
