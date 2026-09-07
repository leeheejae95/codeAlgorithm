package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class SplittingThePowerGridInTwoPractice {

    public int BFS(ArrayList<ArrayList<Integer>> graph, int s, int exclude, int n) {
        int[] ch = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        ch[s] = 1;
        int L = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int curr = q.poll();
                for(int next : graph.get(curr)) {
                    if(ch[next]==0 && next!=exclude) {
                        ch[next] = 1;
                        q.offer(next);
                        L++; // 방문한 노드 카운트
                    }
                }
            }
        }

        return L;
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        for(int[] wire : wires) { // 노드 연결
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        for(int[] wire : wires) {
            int cnt = BFS(graph, wire[0], wire[1], n); // 방문한 노드 cnt
            int diff = Math.abs(cnt-(n-cnt)); // 송전탑의 개수 차이
            answer = Math.min(answer, diff); // 절대값
        }

        return answer;
    }

    public static void main(String[] args) {
        SplittingThePowerGridInTwoPractice T = new SplittingThePowerGridInTwoPractice();
        System.out.println(T.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
        System.out.println(T.solution(4, new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(T.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
    }
}
