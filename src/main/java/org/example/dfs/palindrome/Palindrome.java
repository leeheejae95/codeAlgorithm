package org.example.dfs.palindrome;

import java.util.*;

public class Palindrome {
    Deque<Character> tmp;
    ArrayList<String> res;
    HashMap<Character, Integer> sH;
    int len;
    public void DFS() {
        if(tmp.size() == len){
            String Ts = "";
            for(char x : tmp) Ts += x;
            res.add(Ts);
        }
        else{
            for(char key : sH.keySet()){
                if(sH.get(key) == 0) continue;
                tmp.addFirst(key);
                tmp.addLast(key);
                sH.put(key, sH.get(key) - 2);
                DFS();
                tmp.pollFirst();
                tmp.pollLast();
                sH.put(key, sH.get(key) + 2);
            }
        }
    }

    public String[] solution(String s){
//        String[] answer = {};
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        sH = new HashMap<>();
        len = s.length();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }
        int odd = 0; // 홀수가 몇개인지 체크
        char mid = '#'; // 홀수 인지 판단하기 위해
        for(char key : sH.keySet()){
            if(sH.get(key) % 2 == 1){
                mid = key;
                odd++;
            }
        }
        if(odd > 1) return new String[]{};
        if(mid != '#'){
            tmp.add(mid);
            sH.put(mid, sH.get(mid) - 1);
        }
        DFS();
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args){
        Palindrome T = new Palindrome();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
