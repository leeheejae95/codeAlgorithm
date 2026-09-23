package programers.code.codingtestproblem.lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {

    ArrayList<int[]> list;

    public void DFS(int n, int from, int to, int k) {
        if(n==1) { // 원판이 한게면 더이상 나눌 수 없음
            list.add(new int[]{from,to});
            return;
        }

        DFS(n-1,from,k,to); // n-1개 경유지로
        list.add(new int[]{from,to}); // 가장 큰 것 목적지로
        DFS(n-1,k,to,from); // n-1개 목적지로
    }

    public int[][] solution(int n) {
//        int[][] answer = {};
        list = new ArrayList<>();
        DFS(n,1,3,2); // k : 경유지

        int[][] answer = new int[list.size()][2];
        for(int i=0;i< list.size();i++) answer[i] = list.get(i);

        return answer;
    }

    public static void main(String[] args) {
        TowerOfHanoi T = new TowerOfHanoi();
        System.out.println(Arrays.deepToString(T.solution(2)));
    }
}
