package programers.code.codingtestproblem.lv2.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertNumbersPractice {

    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] ch = new int[y+1];
        q.offer(x);
        while(!q.isEmpty()) {
            int size = q.size();
            answer++;
            for(int i=0;i<size;i++) {
                int cur = q.poll(); // 10
                for(int nx : new int[]{cur+n, cur*2, cur*3}) {
                    if(nx==y) return answer;
                    if(nx<y && ch[nx]==0) {
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ConvertNumbersPractice T = new ConvertNumbersPractice();
        System.out.println(T.solution(10,40,5));
        System.out.println(T.solution(10,40,30));
        System.out.println(T.solution(2,5,4));
    }
}
