import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**

Given a string s, find the length of the longest substring without duplicate characters.

Example:

 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/


public class P3_LongestSubstringWithoutRepeatingCharacters {
//    method 1
    public int lengthOfLongestSubstring(String s) {

        int right = 0;
        int left = 0;
        int maxLength = 0;

        Set<Character> charSet = new HashSet<>();

        while (right < s.length()){
            Character currentChar = s.charAt(right);

            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(currentChar);

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

//    method 2
    public int lengthOfLongestSubstring2(String s) {

        int right = 0;
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        while (right < s.length()){

        Character currentChar = s.charAt(right);

        if(charMap.containsKey(currentChar)){
            left = Math.max(left, charMap.get(currentChar) + 1);
        }

        charMap.put(currentChar, right);
        right++;
        maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        P3_LongestSubstringWithoutRepeatingCharacters answer = new P3_LongestSubstringWithoutRepeatingCharacters();
        int maxLength = answer.lengthOfLongestSubstring2("pwwekw");
        System.out.println(maxLength);
    }

}
