public class LeetCode01_1047 {
    public String removeDuplicates(String s) {
        //1.利用栈的特性模拟过程
        //2.可以直接使用String ,用String模拟
        StringBuffer ret = new StringBuffer();
        int cur = 0;//用来记录比较的位置
        //ret.append(s.charAt(0));
        while(cur < s.length()){
            char tmp = s.charAt(cur);
            if(ret.length() > 0 && ret.charAt(ret.length() - 1) == tmp){
                //出栈
                ret.deleteCharAt(ret.length() - 1);
            }else{
                //进栈
                ret.append(tmp);
            }
            cur++;
        }
        return ret.toString();

    }
}
