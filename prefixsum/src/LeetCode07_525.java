import java.util.HashMap;
import java.util.Map;

/**
 * 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class LeetCode07_525 {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(0,-1);//默认存在一个前缀和为0的情况
        int sum = 0,ret = 0;
        for(int i = 0; i < nums.length;i++){
            //计算当前位置的前缀和
            //先判断当前元素是否为0 ，如果是0 ，就直接＋-1
            sum += (nums[i] == 0 ? -1 : 1);
            //不能计算重复的哈希值
            if(hash.containsKey(sum)){
                ret = Math.max(ret,i-hash.get(sum));
            }else{
                hash.put(sum,i);
            }
        }
        return ret;
    }
}
