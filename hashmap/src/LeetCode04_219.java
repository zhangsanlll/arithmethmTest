import java.util.HashMap;
import java.util.Map;

public class LeetCode04_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //方法：使用哈希表将数组元素和数组下标都存进去，遇到相同的元素先比较下标差是否小于k，若大于直接返回false;
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0 ;i < nums.length;i++){

            if(hash.containsKey(nums[i])){
                if((i - hash.get(nums[i])) <= k) {
                    return true ;
                }
            }
            hash.put(nums[i],i);
        }
        return false ;
    }
   /* public static void main(String[] args) {
        int[] ret = {1,0,1,1};
        System.out.println(containsNearbyDuplicate(ret,1));
    }*/
}
