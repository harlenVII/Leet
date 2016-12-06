public class Solution {
    private static final Map<Character, Integer> ROMAN_TO_INTEGER_MAPPING = new HashMap<>();
    static {
        ROMAN_TO_INTEGER_MAPPING.put('I', 1);
        ROMAN_TO_INTEGER_MAPPING.put('V', 5);
        ROMAN_TO_INTEGER_MAPPING.put('X', 10);
        ROMAN_TO_INTEGER_MAPPING.put('L', 50);
        ROMAN_TO_INTEGER_MAPPING.put('C', 100);
        ROMAN_TO_INTEGER_MAPPING.put('D', 500);
        ROMAN_TO_INTEGER_MAPPING.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null)
            return -1;
        
        int result = 0, prev = 0;
        for (char ch : s.toCharArray()){
            int cur = ROMAN_TO_INTEGER_MAPPING.get(ch);
            result += cur <= prev ? cur : cur - 2 * prev;
            prev = cur;
        }
        return result;
    }
    
}

