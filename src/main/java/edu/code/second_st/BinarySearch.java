package edu.code.second_st;

import java.util.Arrays;

public class BinarySearch {

    public int solution(int n, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int cur_min = 0;
        int cur_max = arr.length-1;
        int cur_target = cur_max + cur_min / 2; // 3
        while(cur_min <= cur_max) {
            if(arr[cur_target] == n) {
                return arr[cur_target];
            }
            if(cur_target < n) {
                cur_min += 1; // cur_target보다 낮게 불렀으니 UP해!!
            } else if(cur_target > n) {
                cur_max -= 1; // cur_target보다 크게 불렀으니 DOWN해!!
            }
            cur_target = (cur_max + cur_min) / 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        BinarySearch T = new BinarySearch();
        System.out.println(T.solution(2,new int[]{0, 3, 5, 6, 1, 2, 4}));
    }
}
