package programers.code.codingtestproblem.lv2;

public class VowelDictionary {

    int answer;
    boolean flag;
    String[] alphabet = {"A", "E", "I", "O", "U"};

    public void DFS(String curr, String word) {
        if(flag) return;
        if(curr.equals(word)) {
            flag = true;
            return;
        }
        if(curr.length() == 5) return; // 길이가 5가되면 호출했던 DFS로 돌아감
        for(String text : alphabet) { // A E I O U
            answer++;
            DFS(curr+text, word);
            if (flag) return;
        }
    }

    public int solution(String word) {
        answer = 0;
        flag = false;
        DFS("",word);

        return answer;
    }

    public static void main(String[] args) {
        VowelDictionary T = new VowelDictionary();
        System.out.println(T.solution("AAAAE"));
        System.out.println(T.solution("AAAE"));
        System.out.println(T.solution("I"));
        System.out.println(T.solution("EIO"));
    }
}
