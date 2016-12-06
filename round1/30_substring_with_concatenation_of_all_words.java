// Time Limit Exceeded
// public class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         if (s == null || words == null || words.length == 0)
//             return null;
//         ArrayList<Integer> result = new ArrayList<>();
//         HashMap<String, Integer> map = new HashMap<>();
//         for (String word : words) {
//             if (map.containsKey(word))
//                 map.put(word, map.get(word) + 1);
//             else
//                 map.put(word, 1);
//         }
//         int wordLength = words[0].length();
        
//         for (int i = 0; i < s.length() - words.length * wordLength; i++) {
//             HashMap<String, Integer> dupMap = new HashMap<>(map);
//             boolean cur = true;
//             for (int j = 0; j < words.length; j++) {
//                 String sub = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
//                 if (dupMap.get(sub) == null) {
//                     cur = false;
//                     break;
//                 }
//                 dupMap.put(sub, dupMap.get(sub) - 1);
//             }
//             //traverse hashmap
//             if (cur == true) {
//                 for (Map.Entry<String, Integer> entry : dupMap.entrySet()) {
//                     if (entry.getValue() != 0) {
//                         cur = false;
//                         break;
//                     }
//                 }
//                 if (cur == true)
//                     result.add(i);
//             }
//         }
//         return result;
//     }
// }

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0)
            return null;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            if (hashMap.containsKey(word))
                hashMap.put(word, hashMap.get(word) + 1);
            else
                hashMap.put(word, 1);
        }
        int wordLength = words[0].length();
        
        for (int i = 0; i < wordLength; i++) {
            int start = i, end = i;
            int counter = words.length;
            HashMap<String, Integer> map = new HashMap<>();
            while (end + wordLength <= s.length()) {
                String sub = s.substring(end, end + wordLength);
                end += wordLength;
                if (!hashMap.containsKey(sub)) { //fail , restart from end
                    start = end;
                    counter = words.length;
                    map.clear();
                    continue;
                }
                if (map.containsKey(sub))
                    map.put(sub, map.get(sub) + 1);
                else
                    map.put(sub, 1);
                    
                if (map.get(sub) <= hashMap.get(sub)) { //belong to words
                    counter--;
                }else{ // the number of sub is more than hashMap
                    map.put(sub, map.get(sub) - 1);
                    while (!s.substring(start, start + wordLength).equals(sub)) {
                        String temp = s.substring(start, start + wordLength);
                        map.put(temp, map.get(temp) - 1);
                        counter++;
                        start += wordLength;
                    }
                    start += wordLength;
                    continue;
                }
                while (counter == 0) { //success
                    result.add(start);
                    sub = s.substring(start, start + wordLength);
                    start += wordLength;
                    if (map.containsKey(sub)) {
                        map.put(sub, map.get(sub) - 1);
                        if (map.get(sub) < hashMap.get(sub)) //invalid
                            counter++;
                    }
                }
            }
        }
        return result;
    }
}


