/**
 * 「外观数列」是一个数位字符串序列，由递归公式定义：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
 */
public class LeetCode04_38 {
    public String countAndSay(int n) {
        //模拟+双指针
        //从第一项开始模拟，然后模拟到第n-1项
        String ret = "1";

        for(int i = 1; i < n;i++){
            StringBuilder tmp = new StringBuilder();//用来存放解释后的序列
            //解释,双指针
            for(int left = 0,right = 0;right < ret.length();){
                while(right < ret.length() && ret.charAt(left) == ret.charAt(right)  ){
                    right++;
                }
                tmp.append(Integer.toString(right - left));
                tmp.append(ret.charAt(left));
                left = right;
            }
            ret = tmp.toString();
        }
        return ret;
    }
}
