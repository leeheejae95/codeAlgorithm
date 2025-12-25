package edu.code.second_st;

public class Factorial {

    public static int DFS(int n) {
        if(n < 0) {
            return 0;
        }
        return (n <=1 ) ? 1 : n * DFS(n-1);
    }

    public static void main(String[] args) {
        System.out.println(DFS(5));
    }
}
