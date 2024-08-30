/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class LeetCode02_34 {
    public int[] searchRange(int[] nums, int target) {

        int[] ret = new int[2];//用来存放结果
        if(nums.length == 0){
            ret[0] =-1;
            ret[1] = -1;
            return ret;
        }
        //先查询左区间的端点
        int left = 0,right = nums.length - 1;
        while(left < right){
            int mid = left +(right -left)/2;
            if(nums[mid] < target){
                left = mid + 1;

            }else{
                right = mid;
            }
        }
        if(nums[left] == target){
            ret[0] = left;
        }else{
            ret[0] = -1;
        }
        //查询右端点
        right = nums.length - 1;
        while(left < right){
            int mid = left +(right -left + 1)/2;
            if(nums[mid] > target){
                right = mid - 1;

            }else{
                left = mid;
            }
        }
        if(nums[left] == target){
            ret[1] = left;
        }else{
            ret[1] = -1;
        }
        return ret;
    }
}
