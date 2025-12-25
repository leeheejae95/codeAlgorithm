package org.example.sortandthink.findsequence;

import java.util.*;

public class FindSequence {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int idx = 0;
        for(int x : nums) {
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for(int x : nums) {
            if(map.get(x) == 0) continue;
            answer[idx] = x;
            idx++;
            map.put(x, map.get(x)-1);
            map.put(x*2, map.get(x*2)-1);
        }

        return answer;
    }

    public static void main(String[] args){
        FindSequence T = new FindSequence();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
