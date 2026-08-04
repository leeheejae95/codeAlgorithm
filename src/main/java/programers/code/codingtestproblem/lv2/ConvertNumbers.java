package programers.code.codingtestproblem.lv2;

import java.util.*;

public class ConvertNumbers {

    public int solution(int x, int y, int n) {
        int answer = 0; // 몇번 연산했는지
        int[] ch = new int[y+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        ch[0] = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int cur = q.poll(); // 10
                for(int nx : new int[]{cur+n, cur*2, cur*3}) {
                    if(nx == y) return answer+1;
                    if(nx < y && ch[nx]==0) {
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            answer++;
        }

        return -1;
    }

    public static void main(String[] args) {
        ConvertNumbers T = new ConvertNumbers();
        System.out.println(T.solution(10,40,5));
        System.out.println(T.solution(10,40,30));
        System.out.println(T.solution(2,5,4));
    }
}
