import java.util.Random;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 快排，不能单纯将数组分成两队进行递归，而是需要分成三块
 */
public class LeetCode02_912 {
    /*public int[] sortArray(int[] nums) {
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
    }*/


    //归并
    int[] tmp;
    public int[] sortArray(int[] nums) {
        //合并排序
        tmp = new int[nums.length];
        mergerSort(nums,0,nums.length - 1);
        return nums;
    }

    public void mergerSort(int[] nums,int left,int right){
        //先判断边界条件
        if(left >= right){
            return;
        }

        //1、取中间数，将数组分成两块
        int mid = (left+right)/2;
        //[left,mid] [mid +1,right]
        //2、对左右两边分别排序
        mergerSort(nums,left,mid);
        mergerSort(nums,mid+1,right);

        //3、合并，使用两个指针分别指向两个区间的左边界，比较大小并交换位置
        int cur1 = left,cur2 = mid+1,i = 0;
        while(cur1 <= mid && cur2 <= right){
            tmp[i++] = nums[cur1] <= nums[cur2] ? nums[cur1++] : nums[cur2++];
        }
        //会存在两个区间的大小不一致，所以还需要处理没有遍历完的数组
        while(cur1 <= mid){
            tmp[i++] = nums[cur1++];
        }
        while(cur2 <= right){
            tmp[i++] = nums[cur2++];
        }
        //4、复原，将tmp的数组赋值到nums中
        //范围是[left,right]
        for(int j = left; j <= right; j++){
            nums[j] = tmp[j -left];
        }
    }
}
