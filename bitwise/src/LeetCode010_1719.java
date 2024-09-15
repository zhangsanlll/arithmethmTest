/**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 * 以任意顺序返回这两个数字均可。
 *
 * 消失的数字+只出现一次的数字3(力扣260)
 */
public class LeetCode010_1719 {

    public int[] missingTwo(int[] nums) {
        //1、先把所有的数异或
        int ret = 0;
        for(int x : nums){
            ret ^= x;
        }
        for(int i = 1;i <= nums.length +2;i++){
            ret ^= i;
        }
        //2、找出a,b两个数比特位不同的一位
        int diff = 0;
        while(true){
            if(((ret >> diff ) & 1) == 1)
                break;
            else
                diff++;
        }

        //3、将所有的数按照diff位不同，分为两类异或
        int[] tmp = new int[2];
        for(int x : nums){
            if(((x >> diff) & 1) == 1)
                tmp[1] ^= x;
            else{
                tmp[0] ^= x;
            }
        }
        for(int i = 1;i <= nums.length +2;i++){
            if(((i >> diff) & 1) == 1)
                tmp[1] ^= i;
            else{
                tmp[0] ^= i;
            }
        }
        return tmp;
    }
}
