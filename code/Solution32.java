package code;

import java.util.Map;
import java.util.stream.Collectors;

public class Solution32 {
    public static String minWindow(String source, String target) {
        // write your code here
        Map<Character, Long> sourceCharCountMap = target.chars().mapToObj(e -> (char) e).collect(Collectors.toMap(e -> e, e -> 0L, (a, b) -> a));
        Map<Character, Long> targetCharCountMap = target.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        int startIndex = 0;
        int valid = 0;
        int resStart = -1;
        int resLength = source.length() + 1;
        // 右移尾指针
        for (int i = 0; i < source.length(); ++i) {
            char curChar = source.charAt(i);
            Long sourceCnt = sourceCharCountMap.get(curChar);
            if (sourceCnt != null) {
                ++sourceCnt;
                if (sourceCnt.equals(targetCharCountMap.get(curChar))) {
                    ++valid;
                }
                sourceCharCountMap.put(curChar, sourceCnt);
            }
            // 右移头指针
            while (valid == targetCharCountMap.size()) {
                int len = i - startIndex + 1;
                if (len < resLength) {
                    resLength = len;
                    resStart = startIndex;
                }
                char startChar = source.charAt(startIndex);
                Long srcCnt = sourceCharCountMap.get(startChar);
                if (srcCnt != null) {
                    --srcCnt;
                    if (srcCnt < targetCharCountMap.get(startChar)) {
                        --valid;
                    }
                    sourceCharCountMap.put(startChar, srcCnt);
                }
                ++startIndex;
            }
        }
        return resStart < 0 ? "" : source.substring(resStart, resStart + resLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("aabbbbbcdd", "abcdd"));
    }
}
