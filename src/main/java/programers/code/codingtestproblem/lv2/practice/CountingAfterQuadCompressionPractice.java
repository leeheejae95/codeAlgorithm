package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class CountingAfterQuadCompressionPractice {

    int[] answer;
    int answerZero,answerOne;
    public boolean isTrue(int[][] arr, int row, int col, int len) {
        int first = arr[row][col];
        for(int i=row;i<row+len;i++) for(int j=col;j<col+len;j++) if(arr[i][j] != first) return false;
        return true;
    }

    public void DFS(int[][] arr, int row, int col, int len) {
        if(isTrue(arr, row, col, len)) {
            if(arr[row][col]==0) {
                answerZero++;
            } else {
                answerOne++;
            }
        } else {
            DFS(arr, row, col,len/2); // 0 0 2
            DFS(arr, row, col+len/2,len/2);
            DFS(arr, row+len/2, col,len/2);
            DFS(arr, row+len/2, col+len/2,len/2);
        }
    }

    public int[] solution(int[][] arr) {
        answer = new int[2];
        answerZero = 0;
        answerOne = 0;
        DFS(arr,0,0,arr.length);
        answer[0] = answerZero;
        answer[1] = answerOne;

        return answer;
    }

    public static void main(String[] args) {
        CountingAfterQuadCompressionPractice T = new CountingAfterQuadCompressionPractice();
        System.out.println(Arrays.toString(T.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1}, {0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})));
    }
}
