package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class LeetCode06_438 {
    public List<Integer> findAnagrams(String ss, String pp) {
        //使用滑动窗口，right往前面走搜寻到有效字符，当有效字符超过三个就记录一下当前字符串的起始位置，
        //left++，无效
        /**int lenP = p.length();
         int count = 0;
         char[] s = ss.toCharArray();
         List<Integer> ret =new ArrayList<>();
         for(int left = 0,right = 0;right <ss.length();right++){
         //进窗口
         if(s[right] == 0 && p.indexOf(s[right]) != -1){
         count++;
         s[right]++;
         }
         //判断
         while(count == lenP && count == right -left +1){
         //满足异位词的条件
         ret.add(left++);
         count--;
         }
         }
         return ret;*/

        List<Integer> ret = new ArrayList<>();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        //统计p字符串中每个字符出现的个数
        int[] hashP =new int[26];
        for(char ch:p){
            hashP[ch -'a']++;
        }
        //统计窗口中每个字符出现的个数
        int[] hash2 = new int[26];
        int lenP = pp.length();
        for(int left = 0,right = 0,count = 0; right < s.length;right++){
            char in = s[right];
            //进窗口
            hash2[in - 'a']++;
            if(hash2[in -'a'] <= hashP[in - 'a']){
                count++;//统计有效字符的个数
            }
            //判断
            if(right -left +1 > lenP){
                //出窗口
                char out = s[left++];
                //如果出的是有效字符，需要count--
                if(hash2[out -'a']-- <= hashP[out - 'a']){
                    count--;
                }
            }
            //更新结果
            if(count == lenP)
                ret.add(left);
        }
        return ret;
    }
}
