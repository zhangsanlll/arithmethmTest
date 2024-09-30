import java.util.*;

public class LeetCode05_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Map<String,String[]><排序后的字符串，异位词>
        //1.读取字符数组的元素，然后排序
        Map<String , List<String>> hash = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            //要对某个字符串单独进行排序，需要将字符串转换成字符数组然后排好序之后再转换成字符串
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String tmp = new String(arr);
            if(!hash.containsKey(tmp)){
                hash.put(tmp,new ArrayList());

            }
            hash.get(tmp).add(strs[i]);
        }

        //2.返回结果
        return new ArrayList(hash.values());
    }
}
