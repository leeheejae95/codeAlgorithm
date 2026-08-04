package programers.code.codingtestproblem.lv2;

import java.util.*;

public class ThirdCompression {

    public int[] solution(String msg) {
//        int[] answer = {};
        int idx = 27;
        String w = "";
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<26;i++) map.put(String.valueOf((char)('A'+i)), i+1); // A ~ Z

        for(char c : msg.toCharArray()) {
            String wc = w + c;
            if(map.containsKey(wc)) { // 포함되어있으면 문자 합치기
                w = wc;
            } else { // 포함안되어있으면 알파벳 마지막에 추가하기
                list.add(map.get(w));
                map.put(wc, idx++);
                w = String.valueOf(c);
            }
        }

        list.add(map.get(w));
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);

        return answer;
    }

    public static void main(String[] args) {
        ThirdCompression T = new ThirdCompression();
        System.out.println(Arrays.toString(T.solution("KAKAO")));
        System.out.println(Arrays.toString(T.solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(T.solution("ABABABABABABABAB")));
    }
}
