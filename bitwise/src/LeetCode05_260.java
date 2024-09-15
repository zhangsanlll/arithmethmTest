/**
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 */
public class LeetCode05_260 {

    public int[] singleNumber(int[] nums) {
        int ret = 0;
        for(int x : nums){
            ret ^= x;
        }
        //取出ret中最右侧的1
        int tmp = ret &(-ret);
        int[] sum = new int[2];
        for(int n: nums){
            if((n & tmp) != 0){
                sum[0] = n ^ sum[0];
            }
        }
        sum[1] = ret ^ sum[0];
        return sum;
    }
}
