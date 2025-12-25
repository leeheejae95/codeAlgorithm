package edu.code.fourth_st.practice;

import java.util.*;

public class RobotClearPractice {
    public int solution(int r, int c, int d, int[][] roomMap) {
        int answer = 0;
        int n = roomMap.length;
        int m  = roomMap[0].length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(true) {
            // 현재 위치 청소
            if(roomMap[r][c] == 0) {
                roomMap[r][c] = 2;
                answer++;
            }

            boolean flag = false;

            for(int k=0;k<4;k++) {
                d = (d+3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && roomMap[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    roomMap[nx][ny] = 2;
                    answer++;
                    flag = true;
                    break;
                }
            }

            if(flag) continue;

            int backD = (d+2) % 4;
            int backX = r + dx[backD];
            int backY = c + dy[backD];

            if(backX<0 || backX>=n || backY<0 || backY>=m || roomMap[backX][backY] == 1) {
                return answer;
            }
            // 뒤로 이동후 좌표
            r =  backX;
            c = backY;
        }
    }

    public static void main(String[] args) {
        RobotClearPractice T = new RobotClearPractice();
        int[][] currentRoomMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println(T.solution(7, 4, 0, currentRoomMap));

        int[][] currentRoomMap2 = { // 29
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println(T.solution(6, 3, 1, currentRoomMap2));

        int[][] currentRoomMap3 = { // 33
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println(T.solution(7, 4, 1, currentRoomMap3));

        int[][] currentRoomMap4 = { // 25
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println(T.solution(6, 2, 0, currentRoomMap4));
    }
}
