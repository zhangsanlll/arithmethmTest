import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 */
public class LeetCode05_560 {
    public int subarraySum(int[] nums, int k) {
        //使用前缀和，不能使用双指针，因为数组有正有负，不具备单调性

        //使用哈希表用来存放前缀和以及出现符合要求的次数
        Map<Integer,Integer> hash = new HashMap<>();

        hash.put(0,1);
        int sum = 0;//用和来代替前缀和
        int ret = 0;//用来
        for(int x: nums){
            sum +=x;//计算当前位置的前缀和
            ret += hash.getOrDefault(sum - k,0);//统计结果
            hash.put(sum,hash.getOrDefault(sum,0)+1);//把当前的前缀和放在哈希表中
        }
        return ret;

    }
}
