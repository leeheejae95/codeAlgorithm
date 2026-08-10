package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class ThirdCompressionPractice {

    public int[] solution(String msg) {
//        int[] answer = {};
        String w = "";
        int idx = 27;
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<Integer> wordList = new ArrayList<>();
        for(int i=0;i<26;i++) map.put(String.valueOf((char)('A'+i)),i+1);

        for(char c : msg.toCharArray()) { // K A K A O
            String wc = w + c;
            if(map.containsKey(wc)) {
                w = wc;
            } else {
                wordList.add(map.get(w));
                map.put(wc,idx++);
                w = String.valueOf(c);
            }
        }
        wordList.add(map.get(w)); // 마지막 문자 처리
        int[] answer = new int[wordList.size()];
        for(int i=0;i<wordList.size();i++) answer[i] = wordList.get(i);

        return answer;
    }

    public static void main(String[] args) {
        ThirdCompressionPractice T = new ThirdCompressionPractice();
        System.out.println(Arrays.toString(T.solution("KAKAO")));
        System.out.println(Arrays.toString(T.solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(T.solution("ABABABABABABABAB")));
    }
}
