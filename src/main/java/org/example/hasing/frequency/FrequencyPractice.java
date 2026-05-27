package org.example.hasing.frequency;

import java.util.*;

public class FrequencyPractice {
    public int[] solution(String s){
        int[] answer = new int[5];
        String tmpStr = "abcde";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int cnt = Integer.MIN_VALUE;
        for(char key : map.keySet()) {
            if(cnt < map.get(key)) {
                cnt = map.get(key);
            }
        }

        for(int i=0; i<tmpStr.length();i++) {
            answer[i] = cnt - map.getOrDefault(tmpStr.charAt(i),0);
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
