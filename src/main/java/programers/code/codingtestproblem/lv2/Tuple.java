package programers.code.codingtestproblem.lv2;

import java.util.*;

public class Tuple {

    public int[] solution(String s) {
//        int[] answer = {};
        HashMap<String,Integer> map = new HashMap<>();
        s = s.replace("{","").replace("}","");
        String[] text = s.split(",");
        for(String x : text) map.put(x, map.getOrDefault(x,0)+1);

        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)-> b.getValue()-a.getValue());

        int[] answer = new int[list.size()];
        for(int i=0;i< list.size();i++) answer[i] = Integer.parseInt(list.get(i).getKey());

        return answer;
    }

    public static void main(String[] args) {
        Tuple T = new Tuple();
        System.out.println(Arrays.toString(T.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(T.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(T.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(T.solution("{{123}}")));
        System.out.println(Arrays.toString(T.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}
