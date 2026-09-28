package programers.code.codingtestproblem.lv2;

import java.util.*;

public class HailSequenceDefiniteIntegral {

    public double[] solution(int k, int[][] ranges) {
//        double[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(k);

        // 2.결과로 나온 수가 1보다 크다면 1번 작업을 반복합니다.
        while(k>1) {
            // 1-1. 입력된 수가 짝수라면 2로 나눕니다.
            if(k%2==0) k = k/2;
            // 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
            else k = k*3+1;
            list.add(k);
        }

        double[] prefix = new double[list.size()];
        for(int i=1;i<list.size();i++) prefix[i] = prefix[i-1]+(list.get(i-1)+list.get(i))/2.0;

        double[] answer = new double[ranges.length];
        int idx = 0;
        // [5, 16, 8, 4, 2, 1]
        for(int[] x : ranges) { // int[][]{시작점, 끝점}
            int n = list.size()-1; // 수열 마지막 인덱스 5
            int start = x[0]; // 시작점 0
            int end = n+x[1]; // 끝점 5
            if(start > end) {answer[idx++] = -1; continue;}
            answer[idx++] = prefix[end]-prefix[start];
        }

        return answer;
    }

    public static void main(String[] args) {
        HailSequenceDefiniteIntegral T = new HailSequenceDefiniteIntegral();
        System.out.println(Arrays.toString(T.solution(5,new int[][]{{0,0},{0,-1},{2,-3},{3,-3}})));
//        System.out.println(Arrays.toString(T.solution(3,new int[][]{{0,0},{1,-2},{3,-3}})));
    }
}
