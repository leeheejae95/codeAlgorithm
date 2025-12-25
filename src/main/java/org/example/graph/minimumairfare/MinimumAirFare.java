package org.example.graph.minimumairfare;

import java.util.*;

public class MinimumAirFare {
    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>(); // 출발도시 번호<목적지,비용> : 출발 도시에서 목적지로 갈 수 있는 경우의 수 추가 하기
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<int[]>());
        }
        int[] costs = new int[n];
        Arrays.fill(costs, 1000000000); // costs배열에 무한대로 넣기
        for(int[] x : flights){
            graph.get(x[0]).add(new int[]{x[1], x[2]}); // 현수가 사는도시 x[0]에서 갈 수 있는 목적지 도시와 비행료 넣기
        }
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{s, 0}); // s번 도시 , s번 도시 까지 가는데 비용
        costs[s] = 0;
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] p = Q.poll();
                int now = p[0]; //현재지점
                int nowcost = p[1]; // 현재지점 비행료
                for(int[] x : graph.get(now)){ // 출발 지점에 대한 목적지랑 비행료 가져오기.
                    int next = x[0]; // 다음 목적지
                    int cost = x[1]; // 다음 목적지 까지의 비행료
                    if(nowcost + cost < costs[next]){
                        costs[next] = nowcost + cost;
                        Q.offer(new int[]{next, costs[next]});
                    }
                }
            }
            L++;
            if(L > k) break;
        }
        
        if(costs[e] == 1000000000) return -1;
        else return costs[e];

//        return answer;
    }

    public static void main(String[] args){
        MinimumAirFare T = new MinimumAirFare();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
