package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 *
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 */
public class LeetCode07_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        //和438题一个类型，找异位词，只是从字符变成了字符串
        List<Integer> ret = new ArrayList<>();
        //将s放入哈希表中

        //统计数组中出现的单词以及次数
        HashMap<String,Integer> hashW = new HashMap<>();
        //将字符数组放入哈希表中
        for(String str:words){
            hashW.put(str,hashW.getOrDefault(str,0)+1);
        }
        int lenW = words.length;
        int len = words[0].length();//每个单词的长度
        for(int i = 0;i < len ;i++){
            //统计窗口单词出现的次数
            HashMap<String,Integer> hashS = new HashMap<>();
            for(int left = i,right = i,count = 0;right +len <= s.length();right+=len){
                //进窗口
                String in = s.substring(right,right+len);
                hashS.put(in,hashS.getOrDefault(in,0)+1);
                if(hashS.get(in) <= hashW.getOrDefault(in,0)){
                    count++;
                }
                //判断
                if(right -left +1 > len * lenW){
                    //出窗口+维护count
                    String out = s.substring(left,left+len);
                    if(hashS.get(out) <= hashW.getOrDefault(out,0)){
                        count--;
                    }
                    hashS.put(out,hashS.getOrDefault(out,0)-1);
                    // hashS.remove(out);
                    left += len;
                }
                //更新结果
                if(count == lenW){
                    ret.add(left);
                }
            }
        }

        return ret;
    }
}
