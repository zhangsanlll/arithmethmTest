/**
 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class LeetCode03_35 {
    public int searchInsert(int[] nums, int target) {
        //找第一个>=target的数的下标，若都不大于，直接插入最后一个位置
        int left = 0,right = nums.length-1;
        if(nums[right] < target){
            return right+1;
        }
        while(left <right){
            int mid = left +(right -left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid;
            }

        }
        return left;
    }
}
