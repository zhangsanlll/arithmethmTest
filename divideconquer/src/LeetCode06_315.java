import java.util.ArrayList;
import java.util.List;

public class LeetCode06_315 {
    int[] tmpNums;//复原原数组
    int[] tmpIndex;//下标复原
    int[] index;//跟踪对应下标
    int[] ret;//最终输出数组
    public List<Integer> countSmaller(int[] nums) {
        //和求逆序对的个数类似，只是这道题变成输出数组，
        //此时我们只需要再多定义两个数组

        //初始化数组
        int n = nums.length;
        tmpIndex = new int[n];
        tmpNums = new int[n];
        index = new int[n];
        ret = new int[n];
        for(int i = 0;i < n;i++){
            index[i] = i;
        }
        mergerSort(nums,0, n-1);
        //将数组转成列表
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ;i < n;i++){
            list.add(ret[i]);
        }
        return list;
    }

    public void mergerSort(int[] nums,int left,int right){
        //判断边界条件
        if(left >= right){
            return;
        }

        //1.
        int mid = (left + right) / 2;
        //2.
        mergerSort(nums,left,mid);
        mergerSort(nums,mid+1,right);
        //3.
        int cur1 = left,cur2 = mid+1,i = 0;
        while(cur1 <= mid && cur2 <= right){
            if(nums[cur1] <= nums[cur2]){
                tmpNums[i] = nums[cur2];
                tmpIndex[i++] = index[cur2++];
            }else{
                ret[index[cur1]] += right -cur2 +1;//最重要的一步
                tmpNums[i] = nums[cur1];
                tmpIndex[i++] = index[cur1++];
            }
        }
        while(cur1 <= mid){
            tmpNums[i] = nums[cur1];
            tmpIndex[i++] = index[cur1++];
        }
        while(cur2 <= right){
            tmpNums[i] = nums[cur2];
            tmpIndex[i++] = index[cur2++];
        }
        //4.
        //[left,right]
        for(int j = left; j <= right; j++){
            nums[j] = tmpNums[j -left];
            index[j] = tmpIndex[j-left];
        }

    }
}
