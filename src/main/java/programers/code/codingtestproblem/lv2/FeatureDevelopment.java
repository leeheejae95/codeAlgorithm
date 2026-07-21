package programers.code.codingtestproblem.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FeatureDevelopment {

    public int[] solution(int[] progresses, int[] speeds) {
//        int[] answer = {};
        ArrayList<Integer> dayCount = new ArrayList<>();
        int[] dayDiff = new int[progresses.length];
        for(int i=0;i< progresses.length;i++) dayDiff[i] = (int) Math.ceil((100.0-progresses[i]) / speeds[i]);

        Queue<Integer> queue = new LinkedList<>();
        for(int day : dayDiff) queue.offer(day); // 7 3 9

        while(!queue.isEmpty()) {
            int x = queue.poll();
            int cnt = 1;
            while(!queue.isEmpty() && queue.peek()<=x) {
                queue.poll();
                cnt++;
            }
            dayCount.add(cnt);
        }
        int[] answer = new int[dayCount.size()];
        for(int i=0;i< answer.length;i++) answer[i] = dayCount.get(i);

        return answer;
    }

    public static void main(String[] args) {
        FeatureDevelopment T = new FeatureDevelopment();
        System.out.println(Arrays.toString(T.solution(new int[]{93,30,55}, new int[]{1,30,5})));
        System.out.println(Arrays.toString(T.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }
}
