package org.example.graph.education;

import java.util.*;

// 두개의 작업이 선후 관계인 경우 전체적인 순서를 찾을때는 위상 정렬로 접근
// 위상정렬은 비순환 방향 그래프에서 정점을 선형으로 정렬하는 것입니다.
// 주로 선후 관계가 있는 일련의 작업을 차례대로
// 수행하기 위해 순서를 정할 때 사용하는 알고리즘
public class Education {
    public String[] solution(String[] subjects, String[] course){
//        String[] answer = {};
        int n = subjects.length;
        HashMap<String, Integer> node = new HashMap<>();
        for(int i = 0; i < n; i++) node.put(subjects[i], i); // 과목별 인덱스 번호 넣기
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n]; // 과목의 진입차수 배열
        for(String x : course){
            int a = node.get(x.split(" ")[0]);
            int b = node.get(x.split(" ")[1]);
            graph.get(b).add(a); // b에서 a로 흐른다(그래프)
            indegree[a]++; // a로 진입
        }
        ArrayList<Integer> order = new ArrayList<>(); // 과목 순서 넣기
        Queue<Integer> queue = new LinkedList<>(); // 큐에는 진입 차수가 0인 과목 넣어 주기
        for(int i = 0; i < n; i++) { // 먼저 들어야 할 과목이 없음
            if(indegree[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            order.add(pre);
            for(int x : graph.get(pre)){
                indegree[x]--;
                if(indegree[x] == 0){
                    queue.offer(x);
                }
            }
        }
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            answer[i] = subjects[order.get(i)];
        }

        return answer;
    }

    public static void main(String[] args){
        Education T = new Education();
        System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"})));
    }
}
