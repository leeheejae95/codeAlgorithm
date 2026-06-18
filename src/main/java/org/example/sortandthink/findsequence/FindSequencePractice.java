package org.example.sortandthink.findsequence;

import java.util.*;

public class FindSequencePractice {
    public int[] solution(int[] nums){
//        int[] answer = {};
        int n = nums.length;
        int[] answer = new int[n/2];
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer[] sorted = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted);
        for(int num : sorted) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int idx = 0;
        for(int key : sorted) {
            if(map.get(key) == 0) continue;
            map.put(key*2, map.get(key*2)-1);
            answer[idx] = key;
            idx++;
        }

        return answer;
    }

    public static void main(String[] args){
        FindSequencePractice T = new FindSequencePractice();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
