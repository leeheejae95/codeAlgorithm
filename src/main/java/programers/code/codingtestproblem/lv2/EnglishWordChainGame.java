package programers.code.codingtestproblem.lv2;

import java.util.*;

public class EnglishWordChainGame {

    public int[] solution(int n, String[] words) {
//        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        String prev = words[0];
        for(int i=1;i< words.length;i++) {
            String curr = words[i];
            if(prev.charAt(prev.length()-1) != curr.charAt(0) || map.containsKey(curr)) {
                int people = (i % n) + 1;
                int turn = (i / n) + 1;
                return new int[]{people, turn};

            }
            map.put(curr, map.getOrDefault(curr,0)+1);
            prev = curr; // 이전단어 현재단어로 갱신
        }

        return new int[]{0,0};
    }

    public static void main(String[] args) {
        EnglishWordChainGame T = new EnglishWordChainGame();
        System.out.println(Arrays.toString(T.solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(T.solution(5,new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(T.solution(2,new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
