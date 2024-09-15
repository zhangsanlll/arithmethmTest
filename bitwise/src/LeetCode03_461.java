import java.util.Scanner;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 */
public class LeetCode03_461 {
    public int hammingDistance(int x, int y) {
        //使用异或，得出的结果是不同位的数
        int sum = x ^ y;
        //然后再计算该数有多少个1
        int ret = 0;
        while(sum != 0){
            ret += sum & 1;
            sum = sum >> 1;
        }
        return ret;
    }

}


