package org.example.greedy.battlegame;

import java.util.*;

class UserInfo implements Comparable<UserInfo>{
    int idx;
    Character team;
    int power;
    UserInfo(int idx,Character team,int power) {
        this.idx = idx;
        this.team = team;
        this.power = power;
    }

    @Override
    public int compareTo(UserInfo o) {
        return this.power - o.power;
    }
}

public class BattleGamePractice {
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<UserInfo> list = new ArrayList();
        for(int i=0; i<n; i++) {
            Character team = students[i].split(" ")[0].charAt(0);
            int power = Integer.parseInt(students[i].split(" ")[1]);
            list.add(new UserInfo(i, team,power));
        }
        Collections.sort(list);
        HashMap<Character,Integer> map = new HashMap<>();
        int j=0,total = 0;
        for(int i=1; i<n; i++) {
            for(; j<n; j++) {
                if(list.get(j).power < list.get(i).power) {
                    total += list.get(j).power;
                    char c =  list.get(j).team;
                    map.put(c, map.getOrDefault(c,0) + list.get(j).power);
                } else break;
            }
            answer[list.get(i).idx] = total - map.getOrDefault(list.get(i).team,0);
        }

        return answer;
    }

    public static void main(String[] args){
        BattleGamePractice T = new BattleGamePractice();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
