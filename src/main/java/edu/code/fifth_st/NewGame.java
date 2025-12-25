package edu.code.fifth_st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class NewGame {
    static int N, K;
    static int[][] color;
    static ArrayList<Integer>[][] cell;
    static int[] x, y, d;

    // 1:오, 2:왼, 3:위, 4:아래
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new  StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        color = new int[N][N]; // 0=흰 , 1=빨, 2=파
        cell = new  ArrayList[N][N]; // 칸별스택
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
                cell[i][j] = new  ArrayList<>();
            }
        }
        // 말 상태
        x = new int[K+1];
        y = new int[K+1];
        d = new int[K+1];
        for(int i=1; i<=K; i++) {
            st = new  StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            x[i] = r; y[i] = c; d[i] = dir;
            cell[r][c].add(i); // 해당칸 스택에 말 올리기
        }
//        System.out.println(simulate());
    }
    // 파란색 또는 범위 밖 -> 방향 반전 후 한번더 시도
    static boolean in(int a, int b) {
        return 0<=a && a<N && 0<=b && b<N;
    }
    static int reverse(int dir) {
        if(dir == 1) return 2;
        if(dir == 2) return 1;
        if(dir == 3) return 4;
        return 3;
    }

    static List<Integer> detachTopFrom(int cx, int cy, int i) {
        ArrayList<Integer> stack = cell[cx][cy];
        int idx = stack.indexOf(i);
        List<Integer> moving = new ArrayList<>(stack.subList(idx, stack.size()));
//        while(stack.size() > idx) stack.remove(s)
        return moving;
    }
}
