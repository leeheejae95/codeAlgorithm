package org.example.dfs.palindrome;

import java.util.*;

public class PalindromePractice {
    HashMap<Character, Integer> map;
    Deque<Character> deque;
    ArrayList<String> res;
    int len;

    public void DFS() {
        if(deque.size() == len) {
            String str = "";
            for(char palindromeStr : deque) {
                str += palindromeStr;
            }
            res.add(str);
        } else {
            for(char str : map.keySet()) {
                if(map.get(str) == 0) continue;
                deque.addFirst(str);
                deque.addLast(str);
                map.put(str, map.get(str)-2);
                DFS();
                deque.pollFirst();
                deque.pollLast();
                map.put(str, map.get(str)+2);
            }
        }
    }

    public String[] solution(String s){
//        String[] answer = {};
        map = new HashMap<>();
        deque = new ArrayDeque<>();
        res = new ArrayList<>();
        len = s.length();
        for(char key : s.toCharArray()) map.put(key, map.getOrDefault(key,0)+1);

        int cnt = 0;
        char mid = '#';
        for(char key : map.keySet()) {
            if(map.get(key) % 2 == 1) {
                mid = key;
                cnt++;
            }
        }
        if(cnt > 1) return new String[]{};
        if(mid != '#') {
            deque.add(mid);
            map.put(mid, map.get(mid)-1);
        }
        DFS();
        String[] answer = new String[res.size()];
        for(int i=0;i<res.size();i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        PalindromePractice T = new PalindromePractice();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
