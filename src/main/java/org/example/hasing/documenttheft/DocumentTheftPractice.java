package org.example.hasing.documenttheft;

import java.util.*;

class UserInfo implements Comparable<UserInfo> {
    String name;
    int time;

    UserInfo(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public int compareTo(UserInfo o) {
        return this.time-o.time;
    }
}

public class DocumentTheftPractice {

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return  H*60+M;
    }

    public String[] solution(String[] reports, String times){
//        String[] answer = {};
        ArrayList<UserInfo> tmp = new ArrayList<>();
        for(String x : reports) {
           String a = x.split(" ")[0];
           int b = getTime(x.split(" ")[1]);
           tmp.add(new UserInfo(a,b));
        }
        Collections.sort(tmp);

        int s = getTime(times.split(" ")[0]);
        int e = getTime(times.split(" ")[1]);
        ArrayList<String> res = new ArrayList<>();
        for(UserInfo u : tmp) {
            if(u.time>=s && u.time<=e) res.add(u.name);
            if(u.time > e) break;
        }
        String[] answer = new String[res.size()];
        for(int i=0; i<res.size(); i++) answer[i] = res.get(i);

        return answer;
    }

    public static void main(String[] args){
        DocumentTheftPractice T = new DocumentTheftPractice();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
