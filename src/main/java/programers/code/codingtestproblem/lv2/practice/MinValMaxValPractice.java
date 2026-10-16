package programers.code.codingtestproblem.lv2.practice;

public class MinValMaxValPractice {

    public String solution(String s) {
//        String answer = "";
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(String num : nums) {
            min = Math.min(min, Integer.parseInt(num));
            max = Math.max(max, Integer.parseInt(num));
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        MinValMaxValPractice T = new MinValMaxValPractice();
        System.out.println(T.solution("1 2 3 4"));
        System.out.println(T.solution("-1 -2 -3 -4"));
        System.out.println(T.solution("-1 -1"));

    }
}
