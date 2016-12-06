import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end;
        for (end = 0; end < s.length(); end++){
            char tmp = s.charAt(end);
            if (map.containsKey(tmp) && map.get(tmp) >= start){
                longestLength = Math.max(end - start, longestLength);
                start = map.get(tmp) + 1;
            }
            map.put(tmp, end);
        }
        return Math.max(longestLength, end - start);
    }
}
