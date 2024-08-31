/**
 * 给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
 *
 * 返回峰值元素的下标。
 *
 * 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
 */
public class LeetCode05_852 {
    public int peakIndexInMountainArray(int[] arr) {
        //分析题目发现该题有二段性，且，开头结尾的两个下标肯定不是正确答案
        int left = 1,right = arr.length - 2;
        while(left < right){
            int mid = left + (right -left +1 )/2;
            if(arr[mid] > arr[mid -1]){
                //说明左边的数都比mid对应下标的数小
                //因为数组是递增的，此时arr[mid]可能是峰值
                left = mid;
            }else{
                right = mid -1;
            }
        }
        return left;
    }
}
