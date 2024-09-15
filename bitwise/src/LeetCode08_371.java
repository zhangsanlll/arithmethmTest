/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 */
public class LeetCode08_371 {
    public int getSum(int a, int b) {
        while(b != 0){
            int m  = a ^ b;
            int n = (a & b) << 1;
            a = m;
            b = n;
        }

        return a;
    }
}
