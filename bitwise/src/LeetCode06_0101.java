/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 */
public class LeetCode06_0101 {

    public boolean isUnique(String astr) {
        //使用鸽巢原理进行优化
        if(astr.length() > 26){
            return false;
        }
        int bitMap= 0;
        for(int i = 0; i < astr.length();i++){
            //先取出每个字符对应的位置放在位图中
            int n = astr.charAt(i) - 'a';
            //先判断该字符是否存在过
            if((1 & (bitMap >> n)) == 1){
                return false;
            }
            //存放字符
            bitMap |=  (1 << n);
        }
        return true;
    }
}
