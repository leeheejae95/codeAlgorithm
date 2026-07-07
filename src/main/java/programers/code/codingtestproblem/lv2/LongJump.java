package programers.code.codingtestproblem.lv2;

public class LongJump {
    public long solution(int n) {
        long[] nums = new long[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i=2;i<=n;i++) {
            nums[i] = (nums[i-1] + nums[i-2]) % 1234567;
        }

        return nums[n];
    }

    public static void main(String[] args) {
        LongJump T = new LongJump();
        System.out.println(T.solution(4));
        System.out.println(T.solution(3));
    }
}
