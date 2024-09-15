/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 */
public class LeetCode09_137 {
    public int singleNumber(int[] nums) {
        //分析每个位图中的比特位，发现每个比特位中只与出现了一次的那个比特位有关

        int bitMap = 0;
        //依次修改bitMap中的每一个比特位
        for(int i = 0;i < 32;i++){
            int sum = 0;
            //统计nums中所有数的第i位和
            for(int x : nums){
                //判断x的第i位是否为1
                if( (1 & (x >> i)) == 1){
                    sum++;
                }
            }
            sum %= 3;
            if(sum == 1){
                bitMap |= 1 << i;
            }

        }
        return bitMap;
    }
}
