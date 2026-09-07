package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class DayUseHotelRoomPractice {

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);

        return H*60+M;
    }

    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String[] timeInfo : book_time) {
            int start = getTime(timeInfo[0]);
            int end = getTime(timeInfo[1]) + 10;
            while(!pq.isEmpty() && pq.peek()<=start) pq.poll();
            pq.offer(end);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        DayUseHotelRoomPractice T = new DayUseHotelRoomPractice();
        System.out.println(T.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
        System.out.println(T.solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
        System.out.println(T.solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
    }
}
