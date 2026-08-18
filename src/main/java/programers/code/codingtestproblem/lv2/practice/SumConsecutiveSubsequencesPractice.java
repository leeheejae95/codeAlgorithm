package programers.code.codingtestproblem.lv2.practice;

import java.util.Arrays;

public class SumConsecutiveSubsequencesPractice {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int lt=0,rt=0;
        int sum=0;
        int minLen = Integer.MAX_VALUE;
        while(lt<=rt && rt<= sequence.length) {
            if(sum==k) {
                int len = rt-lt; //
                if(len < minLen) {
                    minLen=len;
                    answer[0] = lt;
                    answer[1] = rt-1;
                }
                sum -= sequence[lt++]; // 최소조건이 있을수 있어 탐색을 위해 빼준다.
            } else if(sum>k) {
                sum-=sequence[lt++];
            } else {
                if(rt==sequence.length) break;
                sum+=sequence[rt++];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SumConsecutiveSubsequencesPractice T = new SumConsecutiveSubsequencesPractice();
        System.out.println(Arrays.toString(T.solution(new int[]{1,2,3,4,5},7)));
        System.out.println(Arrays.toString(T.solution(new int[]{1,1,1,2,3,4,5},5)));
        System.out.println(Arrays.toString(T.solution(new int[]{2,2,2,2,2},6)));
    }
}
