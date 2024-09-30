import java.util.HashSet;
import java.util.Set;

public class LeetCode03_217 {
    public boolean containsDuplicate(int[] nums) {
        //直接使用哈希表进行排查
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if(!set.add(x)){
                return true;
            }
        }
        return false;
    }
}
