package org.example.simulation.sequence;

import java.util.*;

public class SequencePractice {
    public int solution(int[] nums){
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> peeks = new ArrayList<>();
        for(int i=1; i<n-1; i++) {
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                peeks.add(i);
            }
        }
        for(int x :  peeks) { // 3 7 5
            int lt = x; // 3
            int rt = x; // 3
            int cnt = 1; // 봉우리까지 포함 길이
            while(lt-1>=0 && nums[lt-1] < nums[lt]) { // nums[2] < nums[3] / nums[1] < nums[2]
                cnt++;
                lt--;
            }
            while(rt+1<n && nums[rt+1] < nums[rt]) {
                cnt++;
                rt++;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        SequencePractice T = new SequencePractice();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
