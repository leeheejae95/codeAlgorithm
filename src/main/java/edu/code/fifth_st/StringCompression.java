package edu.code.fifth_st;

public class StringCompression {

    public static int solution(String str) {
        int n = str.length();
        int answer = n;
        for(int step=1; step<=n/2; step++) {
            int len = 0;
            String prev = str.substring(0, step); // for문 첫번째 : 0 1
            System.out.println(prev); // BBA
            int cnt = 1;
            int i = step;

            while(i+step <= n) {
                String cur =  str.substring(i, i+step);
                System.out.println("1111111"+cur);
                if(cur.equals(prev)) {
                    cnt++;
                } else {
                    len += (cnt == 1 ? 0 : String.valueOf(cnt).length()) + prev.length();
                    prev = cur; // prev = ABA
                    cnt = 1;
                }
                i += step;
            }
            len += (cnt == 1 ? 0 : String.valueOf(cnt).length()) + prev.length(); // 3
            len += n-i; // 4-4 = 0

            answer = Math.min(answer, len);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("정답 = 3 / 현재 풀이 값 = " + solution("JAAA"));
        System.out.println("정답 = 9 / 현재 풀이 값 = " + solution("AZAAAZDWAAA"));
        System.out.println("정답 = 12 / 현재 풀이 값 = " + solution("BBAABAAADABBBD"));
    }
}
