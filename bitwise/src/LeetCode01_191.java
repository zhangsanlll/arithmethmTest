/**
 * 找到一个数的二进制数中为1的个数
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中
 * 设置位
 *  的个数（也被称为汉明重量）。
 */
public class LeetCode01_191 {
    public int hammingWeight(int n) {
        //使用位运算
        int ret = 0;
        while(n != 0){
            ret += n & 1;
            n = n >> 1;
        }
        return ret;
    }
}
