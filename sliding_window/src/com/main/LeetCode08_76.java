package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 *如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 */
public class LeetCode08_76 {


    public String minWindow(String s, String tt) {

        //滑动窗口
        //将t中的字符存放到哈希表中
        // HashMap<String,Integer> hashT = new HashMap<>();
        // for(char ch : t){
        //     hashT.put(ch,hashT.getOrDefault(ch,0)+1);
        // }
        // //开始滑动
        // for(int left = 0,right = 0,count = 0;right < s.length();right++){

        // }
        //使用数组进行存放
        if(s.length() < tt.length()){
            return "";
        }
        int[] hashT = new int[256];
        char[] t = tt.toCharArray();
        int kinds = 0;//字符串中有多少种字符
        for(char ch : t){
            if(hashT[ch] ++ == 0)
                kinds++;
        }
        int[] hashS = new int[256];
        int  len = Integer.MAX_VALUE;
        int lenLeft = -1;
        for(int left = 0,right = 0,count = 0;right < s.length();right++){
            char in = s.charAt(right);
            //进窗口
            //hashS[in]++;
            if(++hashS[in] == hashT[in] ){
                count++;//统计有效字符
            }
            //判断
            while(count == kinds){
                //更新结果
                if(right - left +1 < len){
                    len =right - left +1;
                    lenLeft = left;
                }

                //出窗口
                char out  = s.charAt(left);
                left++;
                //hashS[out]--;
                if(hashS[out]-- == hashT[out]){
                    count--;
                }

            }
        }
        if(lenLeft ==-1)
            return new String();
        else
            return s.substring(lenLeft,len+lenLeft);
    }
}
