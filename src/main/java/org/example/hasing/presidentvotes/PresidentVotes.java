package org.example.hasing.presidentvotes;

import java.util.*;

public class PresidentVotes {
    public String solution(String[] votes, int k){
        String answer = " ";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();
        for(String x : votes){ // split을 사용해서 투표자와 후보자를 나눈다
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            voteHash.putIfAbsent(a, new HashSet<String>());
            voteHash.get(a).add(b); // 투표자가 투표한 후보자 set에 넣기
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }
        int max=Integer.MIN_VALUE; // 선물 받을 사람 구하기
        for(String a : voteHash.keySet()){ // 투표자 가져오기
            int cnt = 0;
            for(String b : voteHash.get(a)){ // 투표자가 투표한 사람 가져오기
                if(candidate.get(b) >= k) cnt++;
            }
            present.put(a, cnt); // 선물 받을 사람에 대해 선물 map에 담기
            max = Math.max(max, cnt);
        }
        ArrayList<String> tmp = new ArrayList<>();
        for(String name : present.keySet()){ // 선물 받을사람 리스트에 추가
            if(present.get(name) == max) tmp.add(name);
        }
        tmp.sort((a, b) -> a.compareTo(b)); // 사전순으로 정렬
        answer = tmp.get(0);

        return answer;
    }

    public static void main(String[] args){
        PresidentVotes T = new PresidentVotes();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
