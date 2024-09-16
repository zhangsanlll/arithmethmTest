/**
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *
 * 注意：你 不能 修改非 '?' 字符。
 *
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 */
public class LeetCode01_157 {
    public String modifyString(String ss) {
        //使用模拟思路解决
        char[] s = ss.toCharArray();
        int n = s.length;
        for(int i = 0; i < n;i++){
            //开始替换
            if(s[i] == '?'){
                for(char m = 'a'; m <= 'z';m++){
                    //判断是否为？，有三种情况,左边界、中间、右边界
                    if((i == 0 || s[i-1] != m ) && (i == n-1 || s[i+1] != m )){
                        s[i] = m;
                        break;
                    }
                }
            }
        }
        return String.valueOf(s);
    }
}
