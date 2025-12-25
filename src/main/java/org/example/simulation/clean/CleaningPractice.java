package org.example.simulation.clean;

import java.util.*;

class CleaningPractice {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int x=0, y=0, d=1, cnt=0;
        while(cnt < k) {
            cnt++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0 || nx>=n || ny<0 || ny>=n || board[nx][ny]==1) {
                d = (d+1) % 4;
                continue;
            }
            x = nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    public static void main(String[] args){
        CleaningPractice T = new CleaningPractice();
        int[][] arrO = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arrO, 10)));
        int[][] arrT = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arrT, 20)));
        int[][] arrTh = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arrTh, 25)));

    }
}