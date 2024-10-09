public class LeetCode02_844 {
    public static String removeDuplicates(String s) {
        //1.利用栈的特性模拟过程
        //2.可以直接使用String ,用String模拟
        StringBuffer ret = new StringBuffer();
        int cur = 0;//用来记录比较的位置
        //ret.append(s.charAt(0));
        while(cur < s.length()){
            char tmp = s.charAt(cur++);
            if(ret.length() > 0 && '#' == tmp){
                //出栈
                ret.deleteCharAt(ret.length() - 1);
            }else if(ret.length() == 0 && '#' == tmp){
                continue;
            }else{
                //进栈
                ret.append(tmp);
            }
        }
        return ret.toString();
    }
    public static boolean backspaceCompare(String s, String t) {
        //同1047题解法相同
        System.out.println(
                removeDuplicates(s));
        System.out.println(
                removeDuplicates(t));
        if(removeDuplicates(s).equals(removeDuplicates(t))){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println( backspaceCompare(s,t));
    }
}
