package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class TowerOfHanoiPractice {

    ArrayList<int[]> list;

    public void DFS(int n, int from, int to, int k) {
        // n : 원판갯수
        // k : 경유지
        if(n==1) {
            list.add(new int[]{from,to});
            return;
        }

        DFS(n-1, from, k, to); // DFS(1,1,2,3)
        list.add(new int[]{from,to});
        DFS(n-1, k, to, from); // DFS(1,2,3,1)
    }

    public int[][] solution(int n) {
//        int[][] answer = {};
        list = new ArrayList<>();
        DFS(n,1,3,2);

        int[][] answer = new int[list.size()][2];
        for(int i=0;i< list.size();i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        TowerOfHanoiPractice T = new TowerOfHanoiPractice();
        System.out.println(Arrays.deepToString(T.solution(2)));
    }
}