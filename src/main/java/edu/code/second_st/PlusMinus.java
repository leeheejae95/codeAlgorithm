package edu.code.second_st;

public class PlusMinus {
    static int answer,len, target;
    public static void DFS(int[] nums, int target, int L, int sum) {
        if(L == len) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        DFS(nums, target, L+1, sum + nums[L]);
        DFS(nums, target, L+1, sum - nums[L]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        len = nums.length;
        answer = 0;
        target = 3;
        DFS(nums, target, 0,0);
        System.out.println(answer);
    }
}
