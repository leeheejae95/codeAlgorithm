package programers.code.codingtestproblem.lv2;

import java.util.*;

public class OneCache {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> queue = new LinkedList<>();

        if(cacheSize == 0) return cities.length * 5; // 문제에서 사이즈 범위가 0<=size<=30 이므로 사이즈가 0이면 항상 miss

        for(String city : cities) {
            String cityText = city.toLowerCase();
            if(queue.contains(cityText)) { // hit
                queue.pollFirst();
                queue.addLast(cityText);
                answer += 1;
            } else { // miss
                if(queue.size() == cacheSize) queue.pollFirst();
                queue.addLast(cityText);
                answer += 5;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        OneCache T = new OneCache();
        System.out.println(T.solution(3,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(T.solution(3,new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(T.solution(2,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(T.solution(5,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(T.solution(2,new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(T.solution(0,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}
