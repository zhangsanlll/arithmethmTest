package com.main;

/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
* */
public class LeetCode02_3 {
    public  static int lengthOfLongestSubstring(String ss) {
        //使用滑动窗口＋哈希表
        //如果哈希表能用数组代替尽量用数组代替，因为数组更快
        //将字符串转变成字符数组
        char[] s = ss.toCharArray();
        int[] hash = new int[128];
        int len = 0;
        //有效字符：哈希表中字符的个数为1
        for(int left = 0,right = 0;right < ss.length();right++){
            //进窗口，让hash进入窗口
            hash[s[right]]++;
            //判断,窗口内出现重复字符
            while(hash[s[right]] > 1){
                //滑动窗口中已经有了该有效字符
                //出窗口，从哈希表中删除该字符
                //hash[s[right]]--;
                hash[s[left++]]--;
            }
            //更新结果
            len =Math.max(len,right-left+1);
        }
        return len;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        int ret = lengthOfLongestSubstring(str);
        System.out.println(ret);
    }
}
