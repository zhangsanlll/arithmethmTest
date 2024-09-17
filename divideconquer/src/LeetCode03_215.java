import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LeetCode03_215 {
    public int findKthLargest(int[] nums, int k) {
        return qsort(nums,0,nums.length-1,k);
    }

    //相当于这个递归
    public int qsort(int[] nums,int l ,int r,int k){
        //递归出口
        if( l == r){
            return nums[l];
        }
        //数组分三块，并使用随机数作为基准下标
        //[l ,left]  [left+1,right-1]  [right,n-1]

        //1、随机选择一个基准元素
        int key =nums[new Random().nextInt(r - l +1)+l];
        //2、用基准元素将数组分成三块
        int left = l-1,right = r+1,i = l;
        while( i < right){
            if(nums[i] < key){
                swap(nums,++left,i++);
            }else if(nums[i] == key){
                i++;
            }else{
                swap(nums,--right,i);
            }
        }
        //3、分类讨论
        //[l ,left]  [left+1,right-1]  [right,r]
        int b = right - left -1,c = r-right +1;
        if(c >= k){
            return qsort(nums,right,r,k);
        }else if( b+ c >= k){
            return key;
        }else{
            return qsort(nums,l,left ,k - b - c);
        }
    }

    public void swap(int[] num,int m ,int n){
        int tmp = num[m];
        num[m] = num[n];
        num[n] = tmp;
    }
}
