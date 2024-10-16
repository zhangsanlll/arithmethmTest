import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode03_227 {
    public static int calculate(String s) {
        //使用栈放数字，另外用一个char用来存放操作数
        //循环遍历字符串
        Deque<Integer> stack = new ArrayDeque();
        char op = '+';//为了后续操作统一
        for(int i = 0;i < s.length();){
            //除去空格
            char cur = s.charAt(i);
            if(cur == ' '){
                i++;
            }else if(cur >= '0' && cur <= '9'){
                int tmp = 0;
                while(i < s.length() && s.charAt(i) >= '0' && cur <= '9'){
                    //先将数字提取出来
                    tmp = tmp*10 + (s.charAt(i) - '0');
                    i++;
                }
                if(op == '+'){
                    stack.push(tmp);
                }else if( op == '-'){
                    stack.push(-tmp);
                }else if( op == '*'){
                    stack.push(tmp * stack.pop());
                }else{
                    stack.push(stack.pop() / tmp);
                }
            }else{
                //遇到操作符，更新操作符op
                op = cur;
                i++;
            }
        }

        //至此，全部操作数都已放到栈中，此时遍历栈并依次相加即可
        int ret = 0;
        while(!stack.isEmpty()){
            ret += stack.pop();
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = " 3/2 ";
        System.out.println(
                calculate(s));
    }
}
