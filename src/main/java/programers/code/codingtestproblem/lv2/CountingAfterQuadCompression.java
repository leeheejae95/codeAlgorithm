package programers.code.codingtestproblem.lv2;

import java.util.*;

public class CountingAfterQuadCompression {

    int[] answer;
    int cntZero,cntOne;
    public boolean isAllSame(int[][] arr, int row, int col, int size) {
        int first = arr[row][col];
        for(int i=row;i<row+size;i++) {
            for(int j=col;j<col+size;j++) {
                if(arr[i][j]!=first) {
                    return false;
                }
            }
        }
        return true;
    }

    public void DFS(int[][] arr, int row, int col, int size) {
        if(isAllSame(arr,row,col,size)) {
            if(arr[row][col]==0) {
                cntZero++;
            } else {
                cntOne++;
            }
        } else {
            DFS(arr, row, col, size/2);
            DFS(arr, row, col+size/2, size/2);
            DFS(arr, row+size/2, col, size/2);
            DFS(arr, row+size/2, col+size/2, size/2);
        }
    }

    public int[] solution(int[][] arr) {
        answer = new int[2];
        DFS(arr,0,0,arr.length);
        answer[0] = cntZero;
        answer[1] = cntOne;

        return answer;
    }

    public static void main(String[] args) {
        CountingAfterQuadCompression T = new CountingAfterQuadCompression();
        System.out.println(Arrays.toString(T.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1}, {0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})));
    }
}
