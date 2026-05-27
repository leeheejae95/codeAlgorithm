package org.example.hasing.firstletter;

import java.util.*;

public class FirstLetterPractice {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);

        for(int i=0; i<s.length();i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i+1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        FirstLetterPractice T = new FirstLetterPractice();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
