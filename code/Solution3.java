package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Set<Character> charSet = new HashSet<>();
        for (int cur = 0; cur < s.length(); ++cur) {
            if (charSet.add(s.charAt(cur))) {
                ++end;
            } else {
                int curLength = end - start;
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("a"));
    }
}
