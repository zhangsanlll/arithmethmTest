import java.util.HashMap;
import java.util.Map;

public class LeetCode01_1 {
    public int[] twoSum(int[] nums, int target) {
        /*//解法一，暴力枚举
        int n = nums.length;
        int[] ret = new int[2];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] + nums[j] == target){
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }
        return ret;
        */

        //解法二：使用哈希表
        Map<Integer,Integer> hash = new HashMap<>();//<nums[index],index>
        int n = nums.length;
        for(int i = 0;i < n;i++){

            //先在哈希表总找到该元素
            int tmp = target - nums[i];
            if(hash.containsKey(tmp)){
                return new int[]{i, hash.get(tmp)};
            }
            hash.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        for(int x :nums){
            System.out.println(nums[x]);
        }
    }
}
