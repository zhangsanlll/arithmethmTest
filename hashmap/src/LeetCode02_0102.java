public class LeetCode02_0102 {
    public boolean CheckPermutation(String s1, String s2) {
        //使用数组模拟哈希表
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 != len2){
            return false;
        }
        //1.用一个数组来存入字符串
        int[] hash = new int[26];
        for(int i = 0;i < len1;i++){
            hash[s1.charAt(i) - 'a'] ++;
        }
        //2.与第二个字符串进行比较,有相同的字符就--
        for(int i = 0;i < len1;i++){
            hash[s2.charAt(i) - 'a']--;
            if(hash[s2.charAt(i) - 'a'] == -1){
                return false;
            }
        }
        /*
        //3.最后判断数组中的值是否都为0，如果是，则正确
        for(int i = 0;i < 26;i++){
            if(hash[i] != 0)
                return false;
        }*/
        return true;
    }
}
