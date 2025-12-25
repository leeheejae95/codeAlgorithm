package edu.code.fourth_st.practice;

import java.util.*;

public class RobotClearQueuePractice {
    public int solution(int r, int c, int d, int[][] roomMap) {
        int answer = 0;
        int n =  roomMap.length;
        int m =  roomMap[0].length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{r,c,d});
        while(!Q.isEmpty()) {
            int[] cur = Q.poll();
            int x =  cur[0];
            int y = cur[1];
            int dir = cur[2]; // 현재 방향
            if(roomMap[x][y] == 0) {
                roomMap[x][y] = 2;
                answer++;
            }

            int tmpD = dir;
            for(int k=0; k<4; k++) {
                tmpD = (tmpD + 3) % 4; // 현재 방향 + 3 % 4로 4방향 돌아야됨
                int nx = x + dx[tmpD];
                int ny = y + dy[tmpD];
                if(nx>=0 && nx<n && ny>=0 && ny<m && roomMap[nx][ny] == 0) {
                    roomMap[nx][ny] = 2;
                    answer++;
                    Q.offer(new int[]{nx,ny,tmpD});
                    break; // 전진하고 다시 처음부터 시작
                } else if(k==3) { // 북쪽으로 다시 돌아옴
                    tmpD = (dir + 2) % 4; // 맨처음 방향 그대로 유지한채 후진해야됨 그래서 dir로 구해야됨
                    nx =  x + dx[tmpD];
                    ny = y + dy[tmpD];
                    if(nx>=0 && nx<n && ny>=0 && ny<m &&  roomMap[nx][ny] != 1) {
                        Q.offer(new int[]{nx,ny,dir});
                    } else {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        RobotClearQueuePractice T = new RobotClearQueuePractice();
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
