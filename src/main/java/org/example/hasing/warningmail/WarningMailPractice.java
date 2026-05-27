package org.example.hasing.warningmail;

import java.util.*;

public class WarningMailPractice {

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);

        return H*60+M;
    }

    public String[] solution(String[] reports, int time){
//        String[] answer = {};
        HashMap<String, Integer> inMap = new HashMap<>();
        HashMap<String, Integer> sumMap = new HashMap<>();
        for(String info : reports) {
            String name = info.split(" ")[0]; // 이름
            String timeStatus = info.split(" ")[1]; // 입퇴실 시간
            String result = info.split(" ")[2]; // in / out 결과
            if("in".equals(result)) inMap.put(name, getTime(timeStatus)); // in일경우 inMap에 info 넣기
            else sumMap.put(name, sumMap.getOrDefault(name,0) + getTime(timeStatus) - inMap.get(name)); // out일 경우 나간시간에서 들어온 시간의 차이 맵에 넣기
        }

        ArrayList<String> res = new ArrayList<>();
        for(String key : sumMap.keySet()) {
            if(sumMap.get(key) > time) res.add(key);
        }

        res.sort((a,b) -> a.compareTo(b)); // 사전순으로 정렬
        String[] answer = new String[res.size()];

        for(int i=0;i<res.size();i++) answer[i] = res.get(i);

        return answer;
    }

    public static void main(String[] args){
        WarningMailPractice T = new WarningMailPractice();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
