package org.example.bfs.calfcatch;

import java.util.*;

public class CalfCatchPractice {
    public int solution(int s, int e){
        int answer = 0;
        int[][] ch = new int[2][200001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        ch[0][s] = 1;
        int L = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            L++;
            for(int i = 0; i < len; i++) {
                int x =  q.poll();
                for(int nx : new int[]{x+1,x-1,x*2}) { // 2 0 2
                    if(nx <= 200000 && ch[L%2][nx] == 0) {
                        ch[L%2][nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            e += L;
            if(e > 200000) return -1;
            if(ch[L%2][e] == 1) return  L;
        }

        return -1;
    }

    public static void main(String[] args){
        CalfCatchPractice T = new CalfCatchPractice();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
