package programers.code.codingtestproblem.lv2;

import java.util.Arrays;

public class MatrixMultiplication {

    public int[][] solution(int[][] arr1, int[][] arr2) {
//        int[][] answer = {};
        int n = arr1.length; // 3
        int m = arr2[0].length; // 행의 길이 : 2
        int l = arr2.length; // 열의 길이 : 2
        int[][] answer = new int[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<l;k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
   }

    public static void main(String[] args) {
        MatrixMultiplication T = new MatrixMultiplication();
        System.out.println(Arrays.deepToString(T.solution(new int[][]{{1,4},{3,2},{4,1}}, new int[][]{{3,3},{3,3}})));
        System.out.println(Arrays.deepToString(T.solution(new int[][]{{2,3,2},{4,2,4},{3,1,4}}, new int[][]{{5,4,3},{2,4,1},{3,1,1}})));
    }
}
