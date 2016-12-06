public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        char[] cs = s.toCharArray();
        boolean point = false;
        boolean e = false;
        boolean digit = false;
        boolean digitAfterE = true;
        for (int i = 0; i < cs.length; i++) {
            switch (cs[i]) {
                case '+':
                case '-':
                    if (i != 0 && cs[i - 1] != 'e')
                        return false;
                    break;
                case '.':
                    if (e || point)
                        return false;
                    point = true;
                    break;
                case 'e':
                    if (e || !digit)
                        return false;
                    e = true;
                    digitAfterE = false;
                    break;
                default:
                    if (!Character.isDigit(cs[i]))
                        return false;
                    digit = true;
                    digitAfterE = true;
            }
        }
        return digit && digitAfterE;
    }
}
