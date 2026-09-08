package programers.code.codingtestproblem.lv2;

import java.util.*;

public class TableHashFunction {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(
                data, (a, b) -> {
                    if(a[col-1] != b[col-1]) return a[col-1]-b[col-1]; // col 오름차순
                    return b[0]-a[0]; // 첫번째 컬럼 내림차순
                }
        );

        for(int i=row_begin; i<=row_end; i++) {
            int s = 0;
            for(int val : data[i-1]) s += val % i;
            answer ^= s;
        }

        return answer;
    }

    public static void main(String[] args) {
        TableHashFunction T = new TableHashFunction();
        System.out.println(T.solution(new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}},2,2,3));
    }
}
