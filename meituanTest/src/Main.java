import java.util.Scanner;

public class Main {

    public static void fenlei(String[] str,int n){
        //根据文件类型、版本、日期分类
        //先从字符串数组中分别根据文件类型、版本、日期整合出三个字符串数组
        String[] fileStr = new String[n];
        int f = 0;
        String[] photoStr = new String[n];
        int p = 0;
        String[] videoStr = new String[n];
        int v = 0;

        for(int i = 0;i < n;i++){
            if(str[i].contains("file")){
                fileStr[i] = str[i];
                f++;
            }
            if(str[i].contains("photo")){
                photoStr[i] = str[i];
                p++;
            }
            if(str[i].contains("video")){
                videoStr[i] = str[i];
                v++;
            }
        }
        /**
         * 6
         * file_1_A 2023-01-15
         * photo_2_B 2023-01-20
         * video_3_A 2023-02-10
         * photo_4_A 2023-02-15
         * file_5_A 2023-01-05
         * video_6_B 2023-02-25
         *
         * fileStr:file_1_A 2023-01-15 file_5_A 2023-01-05
         * photoStr:photo_2_B 2023-01-20 photo_4_A 2023-02-15
         * videoStr:video_3_A 2023-02-10 video_6_B 2023-02-25
         */
        //开始比较
        //按类型、版本、日期字典升序
        for(int i = 0;i < f;i++){
            int count = 0;
            //file_1_A 2023-01-15
            //String tmp = fileStr[i].split();

        }

    }

    public static void main(String[] args) {
        //输入信息
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for(int i = 0;i < n;i++){
            in.next();
            str[i] = in.nextLine();
            System.out.println(str[i]);
        }
        //fenlei(str,n);
        System.out.println(str[0].split("_"));
    }
}
