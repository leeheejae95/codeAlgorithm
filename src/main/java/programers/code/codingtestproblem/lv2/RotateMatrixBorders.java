package programers.code.codingtestproblem.lv2;

import java.util.*;

public class RotateMatrixBorders {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows+1][columns+1];
        for(int i=1;i<=rows;i++) {
            for(int j=1;j<=columns;j++) {
                matrix[i][j] = (i-1) * columns + j;
            }
        }

        int idx = 0;
        for(int[] q : queries) {
            int x1=q[0], y1=q[1], x2=q[2], y2=q[3];
            int min = Integer.MAX_VALUE;
            int tmp = matrix[x1][y1];

            // 왼변 (위<-아래): x1+1 ~ x2
            for(int i=x1;i<x2;i++) {
                min = Math.min(min, matrix[i+1][y1]);
                matrix[i][y1] = matrix[i+1][y1]; // 아래값을 위로
            }
            // 아랫변 (왼->오른): y1+1 ~ y2
            for(int j=y1;j<y2;j++) {
                min = Math.min(min, matrix[x2][j+1]);
                matrix[x2][j] = matrix[x2][j+1];
            }
            // 오른변 (아래->위): x2-1 ~ x1
            for(int i=x2;i>x1;i--) {
                min = Math.min(min, matrix[i-1][y2]);
                matrix[i][y2] = matrix[i-1][y2];
            }
            // 윗변 (오른<-왼): y2-1 ~ y1+1
            for(int j=y2;j>y1+1;j--) {
                min = Math.min(min, matrix[x1][j-1]);
                matrix[x1][j] = matrix[x1][j-1];
            }
            matrix[x1][y1+1] = tmp;
            min = Math.min(min, tmp);

            answer[idx++] = min;
        }

        return answer;
    }

    public static void main(String[] args) {
        RotateMatrixBorders T = new RotateMatrixBorders();
        System.out.println(Arrays.toString(T.solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}})));
        System.out.println(Arrays.toString(T.solution(3,3,new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}})));
        System.out.println(Arrays.toString(T.solution(100,97,new int[][]{{1,1,100,97}})));
    }
}
