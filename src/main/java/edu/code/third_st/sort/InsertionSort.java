package edu.code.third_st.sort;

// 선택정렬
public class InsertionSort {
    public int[] solution(int[] nums) {
        int n = nums.length;
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i-j] < nums[i-j-1]) {
                    int tmp = nums[i-j];
                    nums[i-j] = nums[i-j-1];
                    nums[i-j-1] = tmp;
                } else {
                    break;
                }
            }
        }

        return nums;
    }
    public static void main(String[] args) {
        InsertionSort T = new InsertionSort();
        int[] nums = {4,6,2,9,1};
        for(int x : T.solution(nums)) {
            System.out.print(x + " ");
        }
    }
}
