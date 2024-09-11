/**
 * 是191题的变形，返回的是数组
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
 * 计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class LeetCode02_338 {
    public int[] countBits(int n) {
        //使用位运算
        int[] ret = new int[n+1];//存放最后结果
        for(int i = 1;i <= n;i++){
            ret[i] = hammingWeight(i);
        }
        return ret;
    }
    public int hammingWeight(int n) {
        //使用位运算
        int sum = 0;
        while(n != 0){
            sum += n & 1;
            n = n >> 1;
        }
        return sum;
    }
}
