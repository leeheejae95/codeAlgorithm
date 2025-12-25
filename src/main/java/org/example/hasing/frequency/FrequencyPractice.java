package org.example.hasing.frequency;

import java.util.*;

public class FrequencyPractice {
    public int[] solution(String s){
        int[] answer = new int[5];
        String tmp = "abcde";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) map.put(x, map.getOrDefault(x,0)+1);
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
            }
        }
        for(int i=0; i<tmp.length(); i++) {
            answer[i] = max - map.getOrDefault(tmp.charAt(i),0);
        }

        return answer;
    }

    public static void main(String[] args){
        FrequencyPractice T = new FrequencyPractice();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
