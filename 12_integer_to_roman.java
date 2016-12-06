public class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer, String> dic = new TreeMap<>(Collections.reverseOrder());
        dic.put(1000, "M");
        dic.put(900, "CM");
        dic.put(500, "D");
        dic.put(400, "CD");
        dic.put(100, "C");
        dic.put(90, "XC");
        dic.put(50, "L");
        dic.put(40, "XL");
        dic.put(10, "X");
        dic.put(9, "IX");
        dic.put(5, "V");
        dic.put(4, "IV");
        dic.put(1, "I");

        Iterator i = dic.entrySet().iterator();
        String result = new String();
        while (i.hasNext()){
            Map.Entry entry = (Map.Entry)i.next();
            while (num >= (int)entry.getKey()){
                num -= (int)entry.getKey();
                result += entry.getValue();
            }
        }
        return result;
    }
}
