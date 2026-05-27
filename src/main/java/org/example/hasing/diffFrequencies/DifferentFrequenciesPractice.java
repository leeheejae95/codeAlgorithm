package org.example.hasing.diffFrequencies;

import java.util.*;

public class DifferentFrequenciesPractice {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        for(char key : map.keySet()) {
            while(set.contains(map.get(key))) {
                map.put(key,map.get(key)-1);
                answer++;
            }
            if(map.get(key) == 0) continue;
            set.add(map.get(key));
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
