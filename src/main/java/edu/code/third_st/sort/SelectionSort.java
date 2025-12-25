package edu.code.third_st.sort;

public class SelectionSort {
    public int[] solution(int[] nums) {
//        int[] answer = {};
        int n = nums.length;
        for(int i=0; i<n-1; i++) {
            int min_idx = i;
            for(int j=0; j<n-i; j++) {
                if(nums[i+j] < nums[min_idx]) {
                    min_idx = i + j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min_idx];
            nums[min_idx] = tmp;
        }

        return nums;
    }
    public static void main(String[] args) {
        SelectionSort T = new SelectionSort();
        int[] nums = {4,6,2,9,1};
        for(int x : T.solution(nums)) {
            System.out.print(x + " ");
        }
    }
}
