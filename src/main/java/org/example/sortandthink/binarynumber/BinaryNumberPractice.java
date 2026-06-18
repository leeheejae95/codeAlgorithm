package org.example.sortandthink.binarynumber;

import java.util.*;

public class BinaryNumberPractice {

    public int[] solution(int[] nums){
//        int[] answer = {};
        int n = nums.length;
        int[] answer = new int[n];
        int[][] sorted = new int[n][2];
        for(int i=0;i<n;i++) {
            int tmp = nums[i]; // 5
            int cnt = 0;
            while(0 < tmp) {
                cnt += tmp%2; // 5%2=1 / 2%2=0 / 1%2 = 1
                tmp = tmp/2; // 5/2 = 2 / 2/2=1 / 1/2=0
            }
            sorted[i][0] = nums[i];
            sorted[i][1] = cnt;
        }
        Arrays.sort(sorted, (a,b)->a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
        for(int i=0; i<n;i++) {
            answer[i] = sorted[i][0];
        }

        return answer;
    }

    public static void main(String[] args){
        BinaryNumberPractice T = new BinaryNumberPractice();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }

}
