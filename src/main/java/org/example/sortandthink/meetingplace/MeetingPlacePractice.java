package org.example.sortandthink.meetingplace;

import java.util.*;

public class MeetingPlacePractice {
    public int solution(int[][] board) {
        int answer=0;
        int n = board.length;
        ArrayList<Integer> xInfo = new ArrayList<>();
        ArrayList<Integer> yInfo = new ArrayList<>();
        for(int i=0; i<n;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 1) {
                    xInfo.add(i);
                    yInfo.add(j);
                }
            }
        }
        yInfo.sort((a, b) -> a.compareTo(b));
        int x = xInfo.get(xInfo.size()/2);
        int y = yInfo.get(yInfo.size()/2);

        for(int r : xInfo) answer += Math.abs(x-r);
        for(int c : yInfo) answer += Math.abs(y-c);

        return answer;
    }

    public static void main(String[] args){
        MeetingPlacePractice T = new MeetingPlacePractice();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
