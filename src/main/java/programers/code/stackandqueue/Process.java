package programers.code.stackandqueue;

import java.util.*;

public class Process {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i< priorities.length;i++) {
            q.add(new int[]{priorities[i],i}); //{2,0} {1,1} {3,2} {2,3}
        }
        while(!q.isEmpty()) {
            int[] ex = q.poll(); // 2,0
            boolean isTrue = false;
            for(int[] compareQ : q) { // {2,0} {1,1} {3,2} {2,3}
            if(compareQ[0] > ex[0]) {
                    isTrue = true;
                    break; // 찾았으면 for문 탈출
                }
            }
            if(isTrue) {
                q.add(ex); // 있으면 방금 꺼낸거 다시 큐에 넣고
            } else {
                answer++;
                if(location==ex[1]) return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Process T = new Process();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(T.solution(priorities,location));

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;
        System.out.println(T.solution(priorities2,location2));

    }
}
