package org.example.bfs.calfcatch;

import java.util.*;

public class CalfCatchPractice {
    public int solution(int s, int e){
        int answer = 0;
        int[][] ch = new int[2][200001]; // 현수가 이동한 거리
        ch[0][s] = 1;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            L++;
            for(int i=0;i<size;i++) {
                int x = Q.poll();
                for(int nx : new int[]{x+1, x-1, x*2}) {
                    if(nx>=0 && nx<=200000 && ch[L%2][nx] == 0) {
                        ch[L%2][nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            e = e + L;
            if(ch[L%2][e] > 200000) return -1;
            if(ch[L%2][e] == 1) return L;
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
