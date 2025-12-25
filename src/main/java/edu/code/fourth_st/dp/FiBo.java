package edu.code.fourth_st.dp;

public class FiBo {
    public static int DFS(int num) {
        if(num ==1 || num == 2) {
            return 1;
        }
        return DFS(num-1) + DFS(num-2);
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(DFS(n));
    }
}
