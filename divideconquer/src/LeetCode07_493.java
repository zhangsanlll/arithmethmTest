public class LeetCode07_493 {
    int[] tmp;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        tmp = new int[n];
        return mergeSort(nums,0,n-1);
    }

    public int mergeSort(int[] nums,int left,int right){
        //判断
        if(left >= right)
            return 0;
        //1.
        int mid = (left + right) / 2;
        //2.
        int ret = 0;
        ret += mergeSort(nums,left,mid);
        ret += mergeSort(nums,mid+1,right);
        //3.先处理一左一右，计算翻转对
        int cur1 = left,cur2 = mid+1;
        int i = 0;
        //只固定一边就可以了
        //降序
       /* while(cur2 <= right){
            while(cur2 <= right && nums[cur1] /2.0 >= nums[cur2]){
                ret += mid - cur1 +1;
                tmp[i++] = nums[cur2++];
            }else{
                 tmp[i++] = nums[cur1++];
            }
        }*/
        while(cur2 <= right){
            while(cur1 <= mid && nums[cur2] >= nums[cur1] /2.0){
                cur1++;
            }
            if(cur1 > mid)
                break;
            ret += mid - cur1 +1;
            cur2++;
        }

        cur1 = left;cur2 = mid+1;
        while(cur1 <= mid && cur2 <= right){
            if(nums[cur1] <= nums[cur2]){
                tmp[i++] = nums[cur1++];
            } else{
                tmp[i++] = nums[cur2++];
            }
        }
        while(cur1 <= mid){
            tmp[i++] = nums[cur1++];
        }
        while(cur2 <= right){
            tmp[i++] = nums[cur2++];
        }
        //4.
        for(int j = left ;j<= right;j++){
            nums[j] = tmp[j-left];
        }
        return ret;
    }
}
