/**
 * 某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。
 */
public class LeetCode08_173 {
    public int takeAttendance(int[] records) {

        //有二段性，可使用二分查找
        int left = 0,right = records.length-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if(records[mid] == mid){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return records[left] == left?left+1:left;
    }
}
