package programers.code.codingtestproblem.lv2;

import java.util.Arrays;

public class SlicingArray {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        for(long i=left;i<=right;i++) {
            long row = i / n;
            long col = i % n;
            answer[(int)(i-left)] = (int) Math.max(row,col) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        SlicingArray T = new SlicingArray();
        System.out.println(Arrays.toString(T.solution(3,2,5)));
        System.out.println(Arrays.toString(T.solution(4,7,14)));
    }
}
