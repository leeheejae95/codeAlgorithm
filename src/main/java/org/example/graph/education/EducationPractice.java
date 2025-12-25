package org.example.graph.education;

import java.util.*;

public class EducationPractice {
    public String[] solution(String[] subjects, String[] course){
//        String[] answer = {};
        int n = subjects.length;
        HashMap<String, Integer> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.put(subjects[i], i); // 0(eng) 1(math) 2(phy) 3(art) 4(mus)
        ArrayList<ArrayList<Integer>> node = new  ArrayList<>();
        for(int i=0; i<n; i++) node.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(String x : course) {
            int a = graph.get(x.split(" ")[0]); // art(3)
            int b = graph.get(x.split(" ")[1]); // math(1)
            node.get(b).add(a); // 1 : 3
            indegree[a]++; // 3번째 방에 1증가
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) q.offer(i);  // 1번째방, 4번쨰 방이 queue에 들어감
        }
        while(!q.isEmpty()) {
            int cur = q.poll(); // 1, 4 -> 1을 꺼냄
            list.add(cur);
            for(int x : node.get(cur)) { // 1 : 3(2), 2(1)
                indegree[x]--;
                if(indegree[x] == 0) q.offer(x);
            }
        }
        // list : 1 4 3 2 0
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            answer[i] = subjects[list.get(i)];
        }


        return answer;
    }

    public static void main(String[] args){
        EducationPractice T = new EducationPractice();
        System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"})));
    }
}
