package org.example.hasing.presidentvotes;

import java.util.*;

public class PresidentVotesPractice {
    public String solution(String[] votes, int k){
        String answer = "";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>(); // 어떤 학생한테 투표받은 학생 맵
        HashMap<String, Integer> candidate = new HashMap<>(); // 추천받은 학생 맵
        HashMap<String, Integer> present = new HashMap<>(); // 선물 받을 학생 맵
        for(String vote : votes) {
            String candiName = vote.split(" ")[0]; // 추천해준 학생
            String voteName = vote.split(" ")[1]; // 출마한 학생
            voteHash.putIfAbsent(candiName, new HashSet<String>());
            voteHash.get(candiName).add(voteName); // john = [tom, luis]
            candidate.put(voteName, candidate.getOrDefault(voteName,0)+1); // 몇명한테 추천받았는지
        }

        int max = Integer.MIN_VALUE;
        for(String cadiStudentName : voteHash.keySet()) { // daniel luis john
            int cnt = 0;
            for(String voteStudentName : voteHash.get(cadiStudentName)) { // luis, tom
                if(candidate.get(voteStudentName) >= k) {
                    cnt++;
                }
            }
            present.put(cadiStudentName, cnt);
            max = Math.max(max,cnt);
        }

        ArrayList<String> list = new ArrayList<>();
        for(String name : present.keySet()) {
            if(present.get(name) >= max) {
                list.add(name);
            }
        }
        list.sort((a, b) -> a.compareTo(b));
        answer = list.get(0);


        return answer;
    }

    public static void main(String[] args){
        PresidentVotesPractice T = new PresidentVotesPractice();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
