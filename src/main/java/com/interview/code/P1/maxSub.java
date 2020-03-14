package com.interview.code.P1;

public class maxSub {

    /**
     * 最大子序列
     */
    public static void main(String[] args) {
        int[] array = new int[]{3, -1, -6, 5, -7, 2, 9, 0};
        int sum =0;
        int max = array[0];
        for(int num : array){
            if (sum>0){
                sum += num;
            }else {
                sum = num;
            }
            max = Math.max(max,sum);
        }

        System.out.println(max);
    }

    //简单的动态规划
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

}
