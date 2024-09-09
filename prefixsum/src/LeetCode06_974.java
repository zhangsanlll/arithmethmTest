import java.util.HashMap;
import java.util.Map;


/**
 * 和可被K整除的子数组的个数
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。
 *
 * 子数组 是数组中 连续 的部分。
 */
public class LeetCode06_974 {

    public int subarraysDivByK(int[] nums, int k) {
        //第一个用来放余数，第二个用来放次数
        Map<Integer,Integer> hash = new HashMap<>();
        int sum = 0;
        int ret = 0;//用来计算次数
        hash.put(0,1);//前缀和为0的出现了1次
        for(int x:nums){
            sum += x;
            int r = (sum % k + k) % k;
            //统计结果，从哈希表中拿出余数为r的次数，如果没有，就返回0
            ret += hash.getOrDefault(r,0);
            hash.put(r,hash.getOrDefault(r,0)+1);//把当前的前缀和放在哈希表
        }
        return ret;
    }
}
