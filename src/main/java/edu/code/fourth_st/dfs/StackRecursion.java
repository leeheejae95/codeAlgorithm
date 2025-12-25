package edu.code.fourth_st.dfs;

import java.util.*;

public class StackRecursion {
    private static List<Integer> visited = new ArrayList<>();
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    static {
        graph.put(1, Arrays.asList(2, 5, 9));
        graph.put(2, Arrays.asList(1, 3));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, Arrays.asList(3));
        graph.put(5, Arrays.asList(1, 6, 8));
        graph.put(6, Arrays.asList(5, 7));
        graph.put(7, Arrays.asList(6));
        graph.put(8, Arrays.asList(5));
        graph.put(9, Arrays.asList(1, 10));
        graph.put(10, Arrays.asList(9));
    }
    public List<Integer> solution(Map<Integer, List<Integer>> adjacentGraph, int curNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(curNode);
        while(!stack.isEmpty()) {
            int cur_ode = stack.pop();
            visited.add(cur_ode);

            for(int x : adjacentGraph.get(cur_ode)) {
                if(!visited.contains(x)) {
                    stack.push(x);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args){
        StackRecursion T = new StackRecursion();
        System.out.println(T.solution(graph,1));
    }

}
