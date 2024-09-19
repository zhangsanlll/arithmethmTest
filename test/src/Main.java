import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*public void english(){
        //输入数据组数
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t > 0){
            int n = in.nextInt();
            //创建字符串数组来接受单词
            String[] str = new String[n];
            for(int i = 0;i < n;i++){
                str[i] = in.nextLine();
            }
            //统计每个单词中字母出现了多少次
            int[] num = new int[26];
            for(int i = 0;i < n;i++){
                for(int j = 0 ;j < str[i].length();j++){
                    num[str[i].charAt(j) ]++;
                }
            }
            //判断最长单词总长度

            t--;
        }

        //
    }*/

    public String pull(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t > 0 ){
            int N = in.nextInt();//容量
            int n = in.nextInt();//玩具数量
            int c = in.nextInt();//填充量
            int[] num = new int[n];
            for(int i = 0;i < n;i++){
                num[i] = in.nextInt();
            }
            //分两种情况：1.玩具数量刚好够
            //2.不够需要填充物

            //统计玩具数量
            int sum = 0;
            for(int i = 0;i < n;i++){
                 sum += num[i];
                if(sum == N){
                    return "YES";
                }
            }
            if( sum < N){
                for(int j = 0 ;j < c;j++){
                    sum ++;
                    if(sum == N){
                        return "YES";
                    }
                }
            }else if( sum > N){
                return "NO";
            }
            t--;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
