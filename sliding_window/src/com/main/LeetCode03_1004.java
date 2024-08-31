package com.main;

/*
* 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
* */
public class LeetCode03_1004 {
    public int longestOnes(int[] nums, int k) {
        //使用滑动窗口进行解答

        int len = -1;
        int count = 0;//用来计数有多少个0

        for( int left = 0,right = 0;right < nums.length;right++){
            //进窗口
            //统计该下标的数是否为0
            if(nums[right] == 0){
                count ++;
            }
            //判断，判断count 和 k 的数
            while(k < count){
                //出窗口，维护count
                if(nums[left++] == 0){
                    count --;
                }
            }
            //更新结果
            len = Math.max(len , right - left + 1);
        }
        return len;
    }
}
