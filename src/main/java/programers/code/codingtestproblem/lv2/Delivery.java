package programers.code.codingtestproblem.lv2;

import java.util.*;

public class Delivery {

    public int solution(int N, int[][] road, int K) {
        // N : 마을개수 road : 도로정보 K : 배달가능 시간
        int answer = 0;
        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();
        for(int[] x : road) {
            graph[x[0]].add(new int[]{x[1],x[2]});
            graph[x[1]].add(new int[]{x[0],x[2]});
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0; // 시작점

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]); // 거리가 작은 순으로
        pq.offer(new int[]{1,0}); // {노드, 거리}
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[1]>dist[cur[0]]) continue;
            for(int[] next : graph[cur[0]]) {
                int nextNode = next[0];
                int nextCost = next[1]+cur[1];
                if(nextCost<dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode,nextCost});
                }
            }
        }

        for(int i=1;i<=N;i++) if(dist[i]<=K) answer++;

        return answer;
    }

    public static void main(String[] args) {
        Delivery T = new Delivery();
        System.out.println(T.solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3));
        System.out.println(T.solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4));
    }

}
