package com.main;

/*
1658.将x减到0的最小操作数
给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。
请注意，需要 修改 数组以供接下来的操作使用。
如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
* */
public class LeetCode04_1658 {
    public int minOperations(int[] nums, int x) {
        //这道题是209的变形，该题可以转换为求sum-x的最大操作数len，然后用数组长度减去len 即可
        int length = nums.length;
        int len = -1,sum = 0;
        //统计数组总和
        for(int n:nums){
            sum += n;
        }

        int ret = sum - x;
        if(ret < 0){
            return -1;
        }
        int tmp  = 0;//记录窗口中的和
        for(int left = 0,right = 0;right < length;right++){
            //进窗口
            tmp += nums[right];
            //判断
            while(ret < tmp){
                tmp -= nums[left++];
            }
            //更新结果
            if(ret == tmp){
                len = Math.max(len,right - left + 1);
            }

        }
        return (len == -1)? -1:length - len;
    }
}
