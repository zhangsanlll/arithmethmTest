package com.main;

/*
209.长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 target 。找出该数组中满足其总和大于等于 target 的长度最小的
子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
* */
public class LeetCode01_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        //这里min不能是-1，因为后面要求最小值，-1会干扰结果
        int min = Integer.MAX_VALUE;
        while (right < nums.length && left < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                // 满足结果，更新最小值
                int len = right - left + 1;
                min = Math.min(len, min);
                sum = sum - nums[left++];
                //left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;


    }
}
