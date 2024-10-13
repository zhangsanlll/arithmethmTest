public class LeetCode04_43 {
   /* public static String multiply(String n1, String n2) {
        //解法1：模拟列竖式相乘运算
        StringBuffer num2 = new StringBuffer(n2);
        StringBuffer num1 = new StringBuffer(n1);
        num2.reverse();
        num1.reverse();
        String ans = "0";//存放最后结果

        int m = num2.length();
        int n = num1.length();
        if(n1.equals("0") || n2.equals("0")){
            return "0";
        }
        for(int i = 0;i < m;i++){
            StringBuffer tmp = new StringBuffer();//用来存放每次相乘之后的结果，然后再加到ret中
            //先处理前导0
            int t =  i ;
            while( t != 0){
                tmp.append('0');
                t--;
            }
            int add = 0;
            //被除数n2又要和1中的每个数相乘
            //每个数都乘上另外一个字符串
            for(int j = 0;j < n;j++){
                int product = (num2.charAt(i) - '0') *( num1.charAt(j) -'0') + add ;
                tmp.append(product % 10);
                add = product/ 10;
            }
            if(add != 0){
                tmp.append(add % 10);
            }
            ans = addBinary(ans,tmp.reverse().toString());
        }
        return ans;
    }

    public static String addBinary(String a, String b) {
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
            ret.append(tmp % 10);
            tmp /= 10;
        }
        ret.reverse();
        return ret.toString();
    }*/

    public  static String multiply(String n1, String n2) {
        //解法二：先无进位相乘再相加，最后处理进位
        StringBuffer num2 = new StringBuffer(n2);
        StringBuffer num1 = new StringBuffer(n1);
        num2.reverse();
        num1.reverse();
        int m = num2.length();
        int n = num1.length();
        int[] tmp = new int[m+n-1];//存放最后结果
        if(n1.equals("0") || n2.equals("0")){
            return "0";
        }
        //无进位相乘再相加
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                tmp[i+j] += (num1.charAt(i) - '0') *( num2.charAt(j) -'0');
            }
        }
        //处理进位
        int cur = 0;//相当于指针
        int add = 0;//进位
        StringBuffer ret = new StringBuffer();
        while( cur < m+n -1 || add != 0){
            if(cur < (m +n -1))
                add += tmp[cur++];

            ret.append(add % 10 );
            add /= 10;
        }

        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "456";
        System.out.println(multiply(str1, str2));
    }
}
