public class LeetCode02_5 {
    public String longestPalindrome(String s) {
        //奇数回文串和偶数回文串有些细节上的不一样

        //记录子串的起始位置和长度
        int begin = 0,len = 0,n = s.length();
        for(int i = 0;i < n;i++){
            //先扩展奇数长度的子串
            int left = i,right = i;
            while(left >= 0&& right < n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right - left -1 > len){
                begin = left+1;
                len = right-left-1;
            }
            //再扩展偶数长度的子串
            left = i;right = i+1;
            while(left >= 0&& right < n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right - left -1 > len){
                begin = left+1;
                len = right-left-1;
            }
        }
        return s.substring(begin,begin+len);
    }
}
