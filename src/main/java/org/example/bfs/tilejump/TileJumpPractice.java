package org.example.bfs.tilejump;

import java.util.*;

// 레벨탐색
public class TileJumpPractice {
    public int solution(int[] nums){
        int answer = 0;
        int n =  nums.length;
        int[] ch = new int[n];
        Queue<Integer> q = new  LinkedList<>();
        q.offer(0);
        ch[0] = 1;
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int x = q.poll(); // 0
                for(int j=1;j<=nums[x];j++) { // 2
                    int nx = x+j; // 0+1 / 0+2
                    if(nx == n-1) return L+1;
                    if(nx<n && ch[nx] == 0) {
                        ch[nx] = 1;
                        q.offer(nx);
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
