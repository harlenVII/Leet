public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int rotation = numRows * 2 - 2;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j == rotation)
                j = 0;
            if (j < numRows)
                list.get(j++).append(s.charAt(i));
            else if (j < rotation)
                list.get(rotation - j++).append(s.charAt(i));
        }
        String result = new String();
        for (StringBuilder sb : list)
            result += sb.toString();
        return result;
    }
}
