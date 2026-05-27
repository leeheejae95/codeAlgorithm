package org.example.hasing.documenttheft;

import java.util.*;

public class DocumentTheftPractice {
    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);

        return H*60+M;
    }
    public String[] solution(String[] reports, String times){
//        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        for(String info : reports) {
            String name = info.split(" ")[0];
            String time = info.split(" ")[1];
            map.put(name,getTime(time));
        }

        int timeS = getTime(times.split(" ")[0]);
        int timeE = getTime(times.split(" ")[1]);
        ArrayList<String> list = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) >= timeS && map.get(key) <= timeE) {
                list.add(key);
            }
        }
        list.sort((a, b) -> map.get(a)-map.get(b));
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size();i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        DocumentTheftPractice T = new DocumentTheftPractice();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
