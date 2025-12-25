package org.example.dfs.palindrome;

import java.util.*;

public class PalindromePractice {
    Deque<Character> dq;
    HashMap<Character, Integer> map;
    ArrayList<String> res;
    int len;
    public void DFS() {
        if(dq.size() == len) {
            String str = "";
            for(char c : dq) {
                str += c;
            }
            res.add(str);
        } else {
            for(Character key : map.keySet()) {
                if(map.get(key) == 0) continue;
                dq.addFirst(key);
                dq.addLast(key);
                map.put(key, map.get(key)-2);
                DFS();
                dq.pollFirst();
                dq.pollLast();
                map.put(key, map.get(key)+2);
            }
        }
    }
    public String[] solution(String s){
//        String[] answer = {};
        dq = new ArrayDeque<>();
        map = new HashMap<>();
        res = new ArrayList<>();
        len = s.length();
        for(char x : s.toCharArray()) map.put(x, map.getOrDefault(x, 0) + 1);
        int cnt = 0;
        char mid = '#';
        for(char key : map.keySet()) {
            if(map.get(key) % 2 ==1) {
                cnt++;
                mid = key;
            }
        }
        if(cnt > 1) return new String[]{};
        if(mid != '#') {
            dq.push(mid);
            map.put(mid, map.get(mid)-1);
        }
        DFS();
        String[] answer = new String[res.size()];
        for(int i=0; i<res.size();i++) answer[i] = res.get(i);

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
