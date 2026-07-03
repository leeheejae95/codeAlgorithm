package programers.code.codingtestproblem.lv2;

public class MinValMaxVal {

    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(String num : nums) {
            int n = Integer.parseInt(num);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        MinValMaxVal T = new MinValMaxVal();
        System.out.println(T.solution("1 2 3 4"));
        System.out.println(T.solution("-1 -2 -3 -4"));
        System.out.println(T.solution("-1 -1"));

    }
}
