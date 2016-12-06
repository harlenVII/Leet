// public class Solution {
//     public String minWindow(String s, String t) {
//         if (s == null || t == null)
//             return null;
//         int start = 0, end = 0;
//         int head = 0, len = Integer.MAX_VALUE;
//         int counter = t.length();
//         HashMap<Character, Integer> map = new HashMap<>();
        
//         for (char ch : t.toCharArray()) {
//             if (map.containsKey(ch))
//                 map.put(ch, map.get(ch) + 1);
//             else
//                 map.put(ch, 1);
//         }
        
//         while (end < s.length()) {
//             char c = s.charAt(end++);
//             if (!map.containsKey(c))
//                 continue;
//             map.put(c, map.get(c) - 1);
//             if (map.get(c) >= 0) {
//                 counter--;
//             }
//             while (counter == 0) { // valid, then move start
//                 if (end - start < len) {
//                     len = end - start;
//                     head = start;
//                 }
//                 c = s.charAt(start++);
//                 if (map.containsKey(c)) {
//                     map.put(c, map.get(c) + 1);
//                     if (map.get(c) > 0)
//                         counter++;
//                 }
//             }
//         }
//         return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
//     }
// }
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null)
            return null;
        int start = 0, end = 0;
        int head = 0, len = Integer.MAX_VALUE;
        int counter = t.length();
        int[] map = new int[128];
        
        for (char ch : t.toCharArray())
            map[ch]++;
        
        while (end < s.length()) {
            char c = s.charAt(end++);
            if (--map[c] >= 0)
                counter--;
            while (counter == 0) { // valid, then move start
                if (end - start < len) {
                    len = end - start;
                    head = start;
                }
                c = s.charAt(start++);
                if (++map[c] > 0)
                    counter++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }
}
