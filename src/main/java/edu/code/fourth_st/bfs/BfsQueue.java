package edu.code.fourth_st.bfs;

import java.util.*;

public class BfsQueue {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    static {
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, Arrays.asList(1, 5));
        graph.put(3, Arrays.asList(1, 6, 7));
        graph.put(4, Arrays.asList(1, 8));
        graph.put(5, Arrays.asList(2, 9));
        graph.put(6, Arrays.asList(3, 10));
        graph.put(7, Arrays.asList(3));
        graph.put(8, Arrays.asList(4));
        graph.put(9, Arrays.asList(5));
        graph.put(10, Arrays.asList(6));
    }

    public static List<Integer> bfsQueue(Map<Integer, List<Integer>> adjGraph, int startNode) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] ch = new int[graph.size()+1];
        queue.add(startNode);
        ch[startNode] = 1;
        List<Integer> visited = new ArrayList<>();

        while(!queue.isEmpty()){
            int x =  queue.poll();
            visited.add(x);
            for(int node : adjGraph.get(x)) {
                if(ch[node] == 0) {
                    ch[node] = 1;
                    queue.offer(node);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        System.out.println(bfsQueue(graph, 1));
    }
}
