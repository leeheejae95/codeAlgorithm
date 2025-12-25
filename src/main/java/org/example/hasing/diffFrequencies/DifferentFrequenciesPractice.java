package org.example.hasing.diffFrequencies;

import java.util.*;

public class DifferentFrequenciesPractice {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(char x : s.toCharArray()) map.put(x, map.getOrDefault(x,0)+1);
        for(char x : map.keySet()) {
            while(set.contains(map.get(x))) {
                answer++;
                map.put(x, map.get(x)-1);
            }
            if(map.get(x) == 0) continue;
            set.add(map.get(x));
        }

        return answer;
    }

    public static void main(String[] args){
        DifferentFrequenciesPractice T = new DifferentFrequenciesPractice();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
