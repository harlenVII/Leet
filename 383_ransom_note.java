public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null)
            return true;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch))
                return false;
            int num = map.get(ch);
            num--;
            if (num < 0)
                return false;
            map.put(ch, num);
        }
        return true;
    }
}
