package com.main;

import java.util.HashMap;
import java.util.Map;
/*904.水果成篮
你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。

你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：

你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。
每采摘一次，你将会向右移动到下一棵树，并继续采摘。
一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。


* */
public class LeetCode05_904 {
    public int totalFruit(int[] fruits) {
        //使用滑动窗口进行解决
        //哈希表用来存储水果的种类
        Map<Integer,Integer> hash = new HashMap<>();//
        int len = -1;
        //int[] hash = new int[fruits.length];
        for(int left = 0,right = 0;right < fruits.length;right++){
            //进窗口
            hash.put(fruits[right] ,hash.getOrDefault(fruits[right],0)+1);
            //hash[right]++;
            //判断
            while(hash.size() > 2){
                hash.put(fruits[left],hash.get(fruits[left])-1);
                //注意左边界的值减到0之后需要移除这个键
                if(hash.get(fruits[left])== 0){
                    hash.remove(fruits[left]);
                }
                left++;
            }
            len = Math.max(len,right -left +1);
        }
        return len;


    }
}
