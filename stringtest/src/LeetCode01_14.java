public class LeetCode01_14 {
    public String addBinary(String a, String b) {
        StringBuffer ret = new StringBuffer();
        int cur1 = a.length()-1;
        int cur2 = b.length()-1;
        int tmp = 0;
        while(cur1 >=0 || cur2 >= 0 || tmp != 0){
            //分别将两个位置的数字相加
            if(cur1 >= 0){
                tmp += a.charAt(cur1--) -'0';
            }
            if(cur2 >= 0){
                tmp += b.charAt(cur2--) -'0';
            }
            ret.append((char)( '0' + (char)(tmp%2)));
            tmp /= 2;
        }
        ret.reverse();
        return ret.toString();
    }
}
