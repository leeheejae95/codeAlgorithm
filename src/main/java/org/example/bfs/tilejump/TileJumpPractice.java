package org.example.bfs.tilejump;

import java.util.*;

// 레벨탐색
public class TileJumpPractice {
    public int solution(int[] nums){
        int answer = 0;
        int len = nums.length; // 6
        int[] ch = new int[len];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0); // 시작지점
        ch[0] = 1;
        int L = 0;
        while(!Q.isEmpty()) {
            int size = Q.size(); // 1
            for(int i=0;i<size;i++) {
                int x = Q.poll(); // 0
                for(int j=1;j<=nums[x];j++) { // nums[0] = 2
                    int nx = x + j; // 1, 2
                    if(nx == len-1) return L+1;
                    if(nx < len && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        TileJumpPractice T = new TileJumpPractice();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
