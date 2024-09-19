public class LeetCode05_170 {
   static int tmp[];//定义成全局变量，方便后面的方法使用
    public static int reversePairs(int[] nums) {

        //使用归并排序(取中间数将数组一分为二，分别对两区间的数组根据题目要求进行排序，
        //然后合并数组，并复原)

        //这道题在归并思想的基础上再增加一些，一左一右的比较求出符合要求的数量
        int n = nums.length;
        tmp = new int[n];
        return mergeSort(nums,0,n-1);
    }


    public static int mergeSort(int[] nums,int left,int right){
        //判断边界条件
        if(left >= right)//说明该区间的数据要么没有要么只有一个
            return 0;
        //1.取中间数，将数组一分为二
        int mid = (left + right) /2;
        //[left,mid] [mid+1，right]

        int ret = 0;
        //2.分别对这两个区间排序
        ret += mergeSort(nums,left,mid);
        ret += mergeSort(nums,mid+1,right);


        //3.合并并找出符合要求的逆序对
        /*升序
        int cur1 = left,cur2 = mid+1,i = 0;
        while(cur1 <= mid && cur2 <= right){
            if(nums[cur1] <= nums[cur2]){
                tmp[i++] = nums[cur1++];
            } else{
                ret += mid - cur1 + 1;
                cur2++;
            }
        }*/
        //降序
        int cur1 = left,cur2 = mid+1,i = 0;
        while(cur1 <= mid && cur2 <= right){
            if(nums[cur1] <= nums[cur2]){
                tmp[i++] = nums[cur2++];
            } else{
                ret += right - cur2 + 1;
                tmp[i++] = nums[cur1++];
            }
        }
        while(cur1 <= mid)
            tmp[i++] = nums[cur1++];
        while(cur2 <= right)
            tmp[i++] = nums[cur2++];

        //4.排序交换完之后就复原将原来的数组复制成排好序的数组
        //范围是[left,right]
        for(int j = left; j <= right; j++){
            nums[j] = tmp[j -left];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num = {9,7,5,4,6};
        System.out.println(reversePairs(num));
    }
}
