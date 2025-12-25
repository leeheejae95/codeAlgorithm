package org.example.bfs.buildhouse;

import java.util.*;

public class BuildHousePractice {
    public int solution(int[][] board){
        int answer = 0;
        int n = board.length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[][] cost = new  int[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        int emptyLand = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1) {
                    answer = Integer.MAX_VALUE;
                    q.offer(new int[]{i,j});
                    int L = 0;
                    while(!q.isEmpty()) {
                        int len = q.size();
                        L++;
                        for(int r=0;r<len;r++) {
                            int[] x = q.poll();
                            for(int k=0;k<4;k++) {
                                int nx = x[0] + dx[k];
                                int ny = x[1] + dy[k];
                                if(nx>=0 && nx<n && ny<n && ny>=0 && board[nx][ny]==emptyLand) {
                                    board[nx][ny]--;
                                    cost[nx][ny] += L;
                                    q.offer(new int[]{nx,ny});
                                    answer = Math.min(answer, cost[nx][ny]);
                                }
                            }
                        }
                    }
                    emptyLand--;
                }
            }
        }

        return answer==Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args){
        BuildHousePractice T = new BuildHousePractice();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
