/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *
 */
public class LeetCode07_268 {
    public int missingNumber(int[] nums) {
        int tmp = 0;
        int[] ret = new int[nums.length+1];
        for(int i = 0;i <= nums.length;i++){
            ret[i] = i;
            tmp ^= ret[i];
        }
        for(int x : nums){
            tmp  ^=  x;
        }
        return tmp;
    }
}
