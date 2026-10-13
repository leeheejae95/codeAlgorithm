package programers.code.codingtestproblem.lv2.practice;

public class ParenthesisConversionPractice {

    public boolean isValid(String str) {
        int cnt = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='(') cnt++;
            else cnt--;
            if(cnt<0) return false;
        }
        return true;
    }

    public String DFS(String str) {
        if(str.isEmpty()) return "";

        int cnt = 0;
        int idx = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='(') cnt++;
            else cnt--;
            if(cnt==0) { // 균형있는 괄호
                idx = i+1;
                break;
            }
        }

        String u = str.substring(0,idx); // 균형잡힌 문자열
        String v = str.substring(idx); // u를 자르고 남은 문자열
        if(isValid(u)) return u+DFS(v); // 균형잡힌 문자열이면 u 재귀 실행

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<u.length()-1;i++) { // u의 첫번째와 마지막 문자 제거
            if(u.charAt(i)=='(') sb.append(')');
            else sb.append('(');
        }

        // 생성되는 문자열은 "(" + "" + ")" + ""
        return "(" + DFS(v) + ")" + sb.toString();
    }

    public String solution(String p) {
        String answer = "";

        return DFS(p);
    }

    public static void main(String[] args) {
        ParenthesisConversionPractice T = new ParenthesisConversionPractice();
        System.out.println(T.solution("(()())()"));
        System.out.println(T.solution(")("));
        System.out.println(T.solution("()))((()"));
    }
}
