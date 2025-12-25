package org.example.hasing.firstletter;

import java.util.*;

public class FirstLetterPractice {
    public int solution(String s){
        int answer = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) map.put(x, map.getOrDefault(x,0)+1);
        for(int i=0; i<n; i++) {
            if(map.get(s.charAt(i)) == 1) return i+1;
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
