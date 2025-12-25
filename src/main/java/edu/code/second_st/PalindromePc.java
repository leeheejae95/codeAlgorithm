package edu.code.second_st;

public class PalindromePc {

    public static boolean isPalindrome(String string) { //소주만병만주소
        int len = string.length();
        if(string.charAt(0) != string.charAt(len-1)) {
            return false;
        }
        if(len <= 1) {
            return true;
        }
        return isPalindrome(string.substring(1, len-1)); // 주만병만주
    }

    public static void main(String[] args){
        String input = "abcba";

        System.out.println(isPalindrome(input));
    }
}
