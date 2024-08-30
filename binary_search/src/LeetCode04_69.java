
/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class  LeetCode04_69{
    public int mySqrt(int x) {
        //由于x的范围很大，所以需要用long类型
        if( x < 1){
            return 0;
        }
        long left = 1,right = x;
        while(left < right){
            long mid = left+(right - left +1) / 2;
            if(mid * mid > x){
                right = mid - 1;
            }else{
                left = mid;
            }

        }
        return (int)left;
    }
}
