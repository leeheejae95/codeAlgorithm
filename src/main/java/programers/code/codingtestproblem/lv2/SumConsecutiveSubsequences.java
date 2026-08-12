package programers.code.codingtestproblem.lv2;

import java.util.*;

public class SumConsecutiveSubsequences {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int lt = 0, rt = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        while(lt <= rt && rt <= sequence.length) {
            if(sum == k) {
                int len = rt-lt; // 수열의 길이
                if(len < minLen) { // 길이가 짧은 수열 찾기
                    minLen = len;
                    answer[0] = lt; // 2
                    answer[1] = rt-1; // 3
                }
                sum -= sequence[lt++]; // sum:4
            } else if(sum < k) {
                if(rt == sequence.length) break; // 배열 길이보다 길면 안됨
                sum += sequence[rt++]; // sum:10 / rt:4
            } else { // sum이 k보다 클 경우
                sum -= sequence[lt++]; // sum:7 / lt:2
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SumConsecutiveSubsequences T = new SumConsecutiveSubsequences();
        System.out.println(Arrays.toString(T.solution(new int[]{1,2,3,4,5},7)));
        System.out.println(Arrays.toString(T.solution(new int[]{1,1,1,2,3,4,5},5)));
        System.out.println(Arrays.toString(T.solution(new int[]{2,2,2,2,2},6)));
    }
}
