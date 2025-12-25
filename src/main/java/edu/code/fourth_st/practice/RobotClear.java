package edu.code.fourth_st.practice;

import java.util.*;

class RobotClear {
    private static int currentR = 7;
    private static int currentC = 4;
    private static int currentD = 0;
    private static int[][] currentRoomMap = {
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

    // 북   동  남 서
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static int getDIndexWhenRotateToLeft(int d) {
        return (d + 3) % 4;
    }

    public static int getDIndexWhenGoBack(int d) {
        return (d + 2) % 4;
    }

    public static int getCountOfDepartmentsCleanedByRobotVacuum(int r, int c, int d, int[][] roomMap) {
        int n = roomMap.length;
        int m = roomMap[0].length;
        int countOfDepartmentsCleaned = 1;

        roomMap[r][c] = 2;
        Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{r, c, d}); // 1. 루트 노드를 큐에 넣습니다.

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            r = current[0];
            c = current[1];
            d = current[2];
            int tempD = d;

            for (int i = 0; i < 4; i++) {
                tempD = getDIndexWhenRotateToLeft(tempD); // 북 -> 서
                int newR = r + dr[tempD];
                int newC = c + dc[tempD];

                // #     a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
                if (0 <= newR && newR < n && 0 <= newC && newC < m && roomMap[newR][newC] == 0) {
                    countOfDepartmentsCleaned += 1;
                    roomMap[newR][newC] = 2;
                    queue.offer(new int[]{newR, newC, tempD});
                    break;
                }
                // c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
                else if (i == 3) {
                    tempD = getDIndexWhenGoBack(d);
                    newR = r + dr[tempD];
                    newC = c + dc[tempD];

                    // d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                    if (0 <= newR && newR < n && 0 <= newC && newC < m && roomMap[newR][newC] != 1) {
                        queue.offer(new int[]{newR, newC, d});
                    } else {
                        return countOfDepartmentsCleaned;
                    }
                }
            }
        }

        return countOfDepartmentsCleaned;
    }

    public static void main(String[] args) {
        // 57 가 출력되어야 합니다!
        System.out.println(getCountOfDepartmentsCleanedByRobotVacuum(currentR, currentC, currentD, currentRoomMap));
    }
}