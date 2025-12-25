package org.example.graph.minimumairfare;

import java.util.*;

public class MinimumAirFarePractice {
    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int[] x : flights) graph.get(x[0]).add(new int[]{x[1], x[2]});
        int[] ch = new int[n];
        for(int i=0; i<n; i++) Arrays.fill(ch, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});
        int L = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                int[] x = q.poll();
                int now = x[0];
                int nowCost = x[1];
                for(int[] p : graph.get(now)) {
                    int next = p[0];
                    int cost = p[1];
                    if(nowCost + cost < ch[next]) {
                        ch[next] = nowCost + cost;
                        q.offer(new int[]{next, ch[next]});
                    }
                }
            }
            L++;
            if(L > k) break;
        }
        if(ch[e] == Integer.MAX_VALUE) return -1;
        else return ch[e];

//        return answer;
    }

    public static void main(String[] args){
        MinimumAirFarePractice T = new MinimumAirFarePractice();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
