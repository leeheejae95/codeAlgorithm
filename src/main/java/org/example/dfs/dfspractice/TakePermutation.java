package org.example.dfs.dfspractice;

import java.util.Scanner;

public class TakePermutation {
    static int[] pm, arr, ch;
    static int n,m;
    public void DFS(int L){
        if(L==m) {
            for(int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i=0; i<n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        TakePermutation T = new TakePermutation();
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        ch = new int[n];
        pm= new int[m];
        T.DFS(0);
    }
}
