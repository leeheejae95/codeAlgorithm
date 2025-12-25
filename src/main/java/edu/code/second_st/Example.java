package edu.code.second_st;

public class Example {
    static int dfs(int[] nums, int target, int i, int sum, int depth){
        String pad = "  ".repeat(depth);
        System.out.printf(pad+"ENTER i=%d sum=%d\n", i, sum);

        if (i == nums.length) {
            int hit = (sum == target) ? 1 : 0;
            System.out.printf(pad+"LEAF  sum=%d -> %d\n", sum, hit);
            return hit;
        }

        int left  = dfs(nums, target, i+1, sum + nums[i], depth+1);
        System.out.printf(pad+"BACK  + i=%d sum=%d left=%d\n", i, sum, left);

        int right = dfs(nums, target, i+1, sum - nums[i], depth+1);
        System.out.printf(pad+"BACK  - i=%d sum=%d right=%d\n", i, sum, right);

        int ret = left + right;
        System.out.printf(pad+"RET       i=%d sum=%d -> %d\n", i, sum, ret);
        return ret;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println("ANS = " + dfs(nums, target, 0, 0, 0));
    }
}
