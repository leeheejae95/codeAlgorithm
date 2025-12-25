package edu.code.fifth_st;

import java.util.LinkedList;
import java.util.Queue;

public class BeadEscape {
    public static String solution(String[][] gameMap) {
        String answer = "";
        int n = gameMap.length;
        int m = gameMap[0].length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(gameMap[i][j].equals("B") || gameMap[i][j].equals("R")) {
                    queue.add(new int[] {i,j});
                    while(!queue.isEmpty()) {
                        int len =  queue.size();
                        for(int r=0;r<len;r++) {
                            int[] cur = queue.poll();
                        }
                    }
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        String[][] gameMap2 = {
                {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
                {"#", ".", "O", ".", ".", ".", ".", "R", "B", "#"},
                {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
        };
        System.out.println("정답 = false / 현재 풀이 값 = " + solution(gameMap2));


        String[][] gameMap3 = {
                {"#", "#", "#", "#", "#", "#", "#"},
                {"#", ".", ".", "R", "#", "B", "#"},
                {"#", ".", "#", "#", "#", "#", "#"},
                {"#", ".", ".", ".", ".", ".", "#"},
                {"#", "#", "#", "#", "#", ".", "#"},
                {"#", "O", ".", ".", ".", ".", "#"},
                {"#", "#", "#", "#", "#", "#", "#"}
        };
        System.out.println("정답 = true / 현재 풀이 값 = " + solution(gameMap3));
    }
}
