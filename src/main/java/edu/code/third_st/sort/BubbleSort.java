package edu.code.third_st.sort;

public class BubbleSort {
    public int[] solution(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                System.out.println(i + "    " + j);
                if(nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }

        return nums;
    }
    public static void main(String[] args) {
        BubbleSort T = new BubbleSort();
        int[] nums = {13, 5, 11, 7, 23, 15};

        for (int x : T.solution(nums)) {
            System.out.print(x + " ");
        }
    }
}
