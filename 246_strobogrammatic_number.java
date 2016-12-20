public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        map.put('0', '0');
        int start = 0;
        int end = num.length() - 1;
        while (start < end) {
            char ch1 = num.charAt(start++);
            char ch2 = num.charAt(end--);
            if (!map.containsKey(ch1))
                return false;
            if (map.get(ch1) != ch2)
                return false;
        }
        if (start == end) {
            char ch = num.charAt(start);
            if (ch != '1' && ch != '8' && ch != '0')
                return false;
        }
        return true;
    }
}
