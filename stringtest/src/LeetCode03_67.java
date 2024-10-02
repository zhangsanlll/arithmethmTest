public class LeetCode03_67 {
    /*
    public String longestCommonPrefix(String[] strs) {

        //两两比较
        String ret = strs[0];//用来存放最后返回值
        //字符串数组中的每个字符都一起比较相同位置的字符是否一样
        for(int i = 1;i < strs.length;i++){
            //直接写一个函数在函数体内进行两个字符串的比较
            ret = findCommon(ret,strs[i]);
        }
        return ret;
    }
    public String findCommon(String ret,String str){
        int lenMin = Math.min(str.length(),ret.length());
        int i = 0;
        while(i < lenMin && str.charAt(i) == ret.charAt(i)){
            i++;
        }
        return str.substring(0,i);
    }*/

    public String longestCommonPrefix(String[] strs) {
        //统一比较,将第一个字符串作为基准
        for(int i = 0;i < strs[0].length();i++){
            char tmp = strs[0].charAt(i);
            for(int j = 1;j < strs.length;j++){
                if(i == strs[j].length() || strs[j].charAt(i) != tmp){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

}
