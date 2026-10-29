package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class EnglishWordChainGamePractice {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String,Integer> map = new HashMap<>(); // 빈도수 체크용
        String prev = words[0];
        map.put(prev,1);
        for(int i=1;i< words.length;i++) {
            String curr = words[i];
            if(prev.charAt(prev.length()-1)!=curr.charAt(0) || map.containsKey(curr)) { // 단어 끝자리와 첫번째가 다름 || map에 단어 있음
                int people = i%n+1; // 몇번째 사람
                int turn = i/n+1; // 몇번째 턴
                answer[0] = people;
                answer[1] = turn;
                return answer;
            }

            map.put(curr,map.getOrDefault(curr,0)+1);
            prev = curr;
        }

        return answer;
    }

    public static void main(String[] args) {
        EnglishWordChainGamePractice T = new EnglishWordChainGamePractice();
        System.out.println(Arrays.toString(T.solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(T.solution(5,new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(T.solution(2,new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
