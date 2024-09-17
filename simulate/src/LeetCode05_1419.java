import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 *
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 *
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，
 * 那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 */
public class LeetCode05_1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] ch = croakOfFrogs.toCharArray();
        String t = "croak";
        int n = t.length();
        int[] hash = new int[n];
        //[x,x这个字符对应的下标]
        Map<Character,Integer> index = new HashMap<>();
        for(int i = 0;i < n ;i++){
            index.put(t.charAt(i),i);
        }
        for(char tmp :ch){
            if(tmp == t.charAt(0)){
                if(hash[n - 1] != 0){
                    hash[n-1]--;
                }
                hash[0] ++;
            }else{
                int i = index.get(tmp);
                if(hash[i - 1] == 0){
                    return -1;
                }
                hash[i - 1]--;
                hash[i]++;
            }
        }

        for(int i = 0;i < n-1;i++){
            if(hash[i] != 0)
                return -1;
        }
        return hash[n-1];
    }
}
