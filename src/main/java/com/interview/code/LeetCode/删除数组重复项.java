package com.interview.code.LeetCode;

public class 删除数组重复项 {

    class Solution {

        public int removeDuplicates(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            int slow = 0;
            for (int fast = 1; fast < nums.length; fast++) {
                if (nums[fast] != nums[slow]) {
                    slow++;
                    nums[slow] = nums[fast];
                }
            }
            return slow + 1;
        }
    }

}
