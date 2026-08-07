package programers.code.codingtestproblem.lv2;

import java.util.*;

public class FriendsBlock {

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] grid = new char[m][n];
        for(int i=0;i<m;i++) grid[i] = board[i].toCharArray();

        while(true) {
            // 2x2 체크
            int[][] ch = new int[m][n];
            for(int i=0;i<m-1;i++) { // 4
                for(int j=0;j<n-1;j++) { // 5
                    char c = grid[i][j];
                    if(c !=' ' && c==grid[i][j+1] && c==grid[i+1][j] && c==grid[i+1][j+1]) {
                        ch[i][j] = 1;
                        ch[i][j+1] = 1;
                        ch[i+1][j] = 1;
                        ch[i+1][j+1] = 1;
                    }
                }
            }

            // 제거
            int removed = 0;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(ch[i][j]==1) {
                        grid[i][j] = ' ';
                        removed++;
                    }
                }
            }

            if(removed == 0) break; // 제거 없으면 종료
            answer += removed;

            for(int j=0;j<n;j++) { // 열 순회
                Stack<Character> stack = new Stack<>();
                for(int i=0;i<m;i++) { // 행 순회
                    if(grid[i][j] != ' ') stack.push(grid[i][j]);
                }
                for(int i=m-1;i>=0;i--) { // 밑에 행부터 채우기
                    grid[i][j] = stack.isEmpty() ? ' ' : stack.pop();
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FriendsBlock T = new FriendsBlock();
        System.out.println(T.solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(T.solution(6,6,new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }
}
