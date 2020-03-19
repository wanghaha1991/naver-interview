package offer;

import java.util.HashSet;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class 组中重复的数字 {
    static class Solution {
        public static int findRepeatNumber(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i: nums){
                if (set.contains(i)){
                    return i;
                }
                set.add(i);
            }
            return 0;
        }

        public static void main(String[] args) {
           int[] ints = {0, 1, 2, 3, 4, 155, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            System.out.println(findRepeatNumber(ints));
        }
    }
}
