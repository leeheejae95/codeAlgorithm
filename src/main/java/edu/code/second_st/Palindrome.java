package edu.code.second_st;

public class Palindrome {

    public static boolean isPalindrome(String string) { //소주만병만주소
        if (string.charAt(0) != string.charAt(string.length() - 1)) {
            return false;
        }
        if (string.length() <= 1) {
            return true;
        }

        return isPalindrome(string.substring(1, string.length() - 1)); // 주만병만주
    }

    public static void main(String[] args){
        String input = "abcba";

        System.out.println(isPalindrome(input));
    }
}
