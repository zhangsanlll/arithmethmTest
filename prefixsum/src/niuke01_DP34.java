import java.util.Comparator;
import java.util.Scanner;


/**
 * 牛客网网址
 * https://www.nowcoder.com/practice/acead2f4c28c401889915da98ecdc6bf?tpId=230&tqId=2021480&ru=
 * /exam/oj&qru=/ta/dynamic-programming/question-ranking&sourceUrl=
 * %2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196
 */
public class niuke01_DP34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //1、输入两行整数和数组
        int n = in.nextInt();
        int q = in.nextInt();
        int arr[] = new int[n+1];
        for(int i = 1; i <= n;i++){
            arr[i] = in.nextInt();
        }
        arr[0] = 0;

        //2、预处理一个前缀和数组
        long[] dp = new long[n+1];
        dp[0] = 0;
        for(int i = 1;i <= n;i++){
            dp[i] = dp[i-1]+arr[i];
        }

        //3、使用前缀和数组
        while(q > 0){
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(dp[r] - dp[l-1]);
            q--;
        }
        Comparator
    }

}
