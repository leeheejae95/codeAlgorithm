package programers.code.codingtestproblem.lv2;

import java.util.*;

public class SplittingThePowerGridInTwo {

    public int BFS(ArrayList<ArrayList<Integer>> graph, int start, int exclude, int n) {
        int[] ch = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        ch[start] = 1;
        int cnt = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph.get(cur)) {
                if(ch[next]==0 && next!=exclude) {
                    ch[next] = 1;
                    q.offer(next);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());

        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        for(int[] wire : wires) {
            int count = BFS(graph,wire[0],wire[1],n);
            int diff = Math.abs(count-(n-count));
            answer = Math.min(answer,diff);
        }

        return answer;
    }

    public static void main(String[] args) {
        SplittingThePowerGridInTwo T = new SplittingThePowerGridInTwo();
        System.out.println(T.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
        System.out.println(T.solution(4, new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(T.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
    }
}
