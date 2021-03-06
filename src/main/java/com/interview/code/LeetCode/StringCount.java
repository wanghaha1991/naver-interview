package com.interview.code.LeetCode;

public class StringCount {
    public static String countString(String source) {
        StringBuilder target = new StringBuilder();
        int length = source.length();
        if (length == 0){
            return target.toString();
        }
        int slow = 0;
        for (int fast = 0; fast <= length; fast++) {
            if (fast == length || source.charAt(slow) != source.charAt(fast)) {
                target.append(source.charAt(slow)).append(fast - slow);
                slow = fast;
            }
        }
        return target.toString();
    }
}
