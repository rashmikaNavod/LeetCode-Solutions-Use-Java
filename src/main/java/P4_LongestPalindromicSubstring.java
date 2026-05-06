import java.util.HashMap;
import java.util.Map;

/**

Given a string s, return the longest palindromic substring in s.

*/


public class P4_LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        if(s == null || s.isEmpty()) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++){
            String s1 = expand(s,i,i);
            if(s1.length() > longest.length()){
                longest = s1;
            }

            String s2 = expand(s,i,i+1);
            if(s2.length() > longest.length()){
                longest = s2;
            }
        }

        return longest;
    }

    private static String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }


    public static void main(String[] args) {
        String output = longestPalindrome("babbeadae");
        System.out.println(output);
    }
}
