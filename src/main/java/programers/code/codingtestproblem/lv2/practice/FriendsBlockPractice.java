package programers.code.codingtestproblem.lv2.practice;

import java.util.*;

public class FriendsBlockPractice {

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] block = new char[m][n];
        for(int i=0;i<m;i++) block[i] = board[i].toCharArray();

        while(true) {
            int[][] ch = new int[m][n];
            for(int i=0;i<m-1;i++) { // 행
                for(int j=0;j<n-1;j++) { // 열
                    char c = block[i][j];
                    if(c !=' ' && c==block[i][j+1] && c==block[i+1][j] && c==block[i+1][j+1]) {
                        ch[i][j] = 1;
                        ch[i][j+1] = 1;
                        ch[i+1][j] = 1;
                        ch[i+1][j+1] = 1;
                    }
                }
            }

            // 제거하기
            int removed = 0;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(ch[i][j]==1) {
                        block[i][j] = ' ';
                        removed++;
                    }
                }
            }

            if(removed == 0) break;
            answer += removed;

            for(int j=0;j<n;j++) { // 열순회
                Stack<Character> stack = new Stack<>();
                for(int i=0;i<m;i++) { // 행순회
                    if(block[i][j] != ' ') {
                        stack.push(block[i][j]);
                    }
                }
                for(int i=m-1;i>=0;i--) { // 행순회
                    block[i][j] = stack.isEmpty() ? ' ' : stack.pop();
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FriendsBlockPractice T = new FriendsBlockPractice();
        System.out.println(T.solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(T.solution(6,6,new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }
}
