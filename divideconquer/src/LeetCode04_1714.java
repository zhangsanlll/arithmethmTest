import java.util.Random;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 */
public class LeetCode04_1714 {
    public int[] smallestK(int[] nums, int k) {
        qsort(nums,0,nums.length - 1,k);
        int[] ret = new int[k];
        for(int i = 0 ;i < k ;i++){
            ret[i] = nums[i];
        }
        return ret;
    }

    public void qsort(int[] nums,int l,int r,int k){
        //递归出口
        if( l >= r){
            return ;
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
        int a = left - l +1,b = right - left -1;
        if(a > k){
            qsort(nums,l,left,k);
        }else if( a + b >= k){
            return ;
        }else{
            qsort(nums,right,r ,k - b - a);
        }
    }

    public void swap(int[] num,int m ,int n){
        int tmp = num[m];
        num[m] = num[n];
        num[n] = tmp;
    }
}
