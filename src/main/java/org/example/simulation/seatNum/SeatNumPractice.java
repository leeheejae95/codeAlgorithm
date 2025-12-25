package org.example.simulation.seatNum;

import java.util.Arrays;

public class SeatNumPractice {
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[][] seats = new int[c][r];
        int x=0,y=0,d=1,cnt=1;
        if(k > c*r) return new int[]{0,0};
        while(cnt < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0 || nx>=c || ny<0 || ny>=r || seats[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            seats[x][y] = cnt++;
            x = nx;
            y = ny;
        }
        answer[0] = x+1;
        answer[1] = y+1;

        return answer;
    }

    public static void main(String[] args){
        SeatNumPractice T = new SeatNumPractice();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
