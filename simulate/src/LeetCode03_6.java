/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 */
public class LeetCode03_6 {
    public String convert(String s, int numRows) {
        //模拟+找规律
        int n = s.length();
        int d = 2 * numRows - 2;
        StringBuilder str = new StringBuilder();

        if(1 == numRows)
            return s;

        //所有的循环都是枚举的行数
        //先处理第一行
        for(int i = 0;i < n;i += d){
            str.append(s.charAt(i));
        }
        //再处理中间行
        for(int k = 1; k < numRows - 1;k++){
            for(int i = k,j = d - i; i < n || j < n;i+=d,j += d){
                if(i < n){
                    str.append(s.charAt(i));
                }
                if(j < n){
                    str.append(s.charAt(j));
                }
            }
        }
        //最后一行
        for(int i = numRows - 1;i < n;i += d){
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}
