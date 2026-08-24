package programers.code.codingtestproblem.lv2;

import java.util.Arrays;

public class TriangularSnail {

    public int[] solution(int n) {
//        int[] answer = {};
        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        int[][] make = new int[n][n];
        int x=0,y=0,d=0,num=1;
        for(int i=n;i>0;i--) {
            for(int j=0;j<i;j++) {
                make[x][y] = num++;
                if(j<i-1) {
                    x+=dx[d];
                    y+=dy[d];
                }
            }
            d = (d+1)%3;
            x += dx[d];
            y += dy[d];
        }

        int[] answer = new int[n*(n+1)/2];
        int idx=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                answer[idx++] = make[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        TriangularSnail T = new TriangularSnail();
        System.out.println(Arrays.toString(T.solution(4)));
        System.out.println(Arrays.toString(T.solution(5)));
        System.out.println(Arrays.toString(T.solution(6)));
    }
}
