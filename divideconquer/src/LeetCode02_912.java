import java.util.Random;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 快排，不能单纯将数组分成两队进行递归，而是需要分成三块
 */
public class LeetCode02_912 {
    public int[] sortArray(int[] nums) {
        //使用“数组换分成三块”，这个在拍重复数字时不会超时


        qsort(nums,0,nums.length - 1);
        return nums;
    }

    //相当于这个递归
    public void qsort(int[] nums,int l ,int r){
        //递归出口
        if( l >= r){
            return ;
        }

        //数组分三块，并使用随机数作为基准下标
        //[l ,left]  [left+1,right-1]  [right,n-1]
        int left = l-1,right = r+1,i = l;
        int key =nums[new Random().nextInt(r - l +1)+l];
        while( i < right){
            if(nums[i] < key){
                swap(nums,++left,i++);
            }else if(nums[i] == key){
                i++;
            }else{
                swap(nums,--right,i);
            }
        }
        //[l ,left]  [left+1,right-1]  [right,r],还剩两边递归
        qsort(nums,l,left);
        qsort(nums,right,r);
    }

    public void swap(int[] num,int m ,int n){
        int tmp = num[m];
        num[m] = num[n];
        num[n] = tmp;
    }
}
