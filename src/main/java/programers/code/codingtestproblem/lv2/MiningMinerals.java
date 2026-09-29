package programers.code.codingtestproblem.lv2;

import java.util.*;

public class MiningMinerals {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        // picks : (다이아, 아이언, 스톤)
        ArrayList<int[]> groups = new ArrayList<>();
        for (int i=0;i<minerals.length;i += 5) {
            int[] group = new int[3];
            for (int j = i; j < Math.min(i + 5, minerals.length); j++) {
                if (minerals[j].equals("diamond")) group[0]++;
                else if (minerals[j].equals("iron")) group[1]++;
                else group[2]++;
            }
            groups.add(group);
        }

        // 곡괭이 총 개수보다 묶음이 많으면 자르기
        int totalPicks = picks[0] + picks[1] + picks[2];
        while(groups.size() > totalPicks) {
            groups.remove(groups.size()-1);
        }

        groups.sort((a, b) -> {
            if(a[0] != b[0]) return b[0]-a[0];
            if(a[1] != b[1]) return b[1]-a[1];
            return b[2]-a[2];
        });

        int[][] fatigue = {
                {1, 1, 1},   // 다이아 곡괭이
                {5, 1, 1},   // 철 곡괭이
                {25, 5, 1}   // 돌 곡괭이
        };

        int picksIdx = 0;
        for(int[] group : groups) { // [3, 2, 0] [1, 1, 1]
            // picks에서 현재 곡괭이 찾기
            while(picksIdx<3 && picks[picksIdx]==0) picksIdx++;
            if(picksIdx==3)  break;

            answer += group[0] * fatigue[picksIdx][0]
                    + group[1] * fatigue[picksIdx][1]
                    + group[2] * fatigue[picksIdx][2];

            picks[picksIdx]--;
        }

        return answer;
    }

    public static void main(String[] args) {
        MiningMinerals T = new MiningMinerals();
        System.out.println(T.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
        System.out.println(T.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }
}
