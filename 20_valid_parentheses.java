public class Solution {
    public boolean isValid(String s) {
        if (s == null)
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty())
                        return false;
                    char c = stack.pop();
                    if (!match(c, s.charAt(i)))
                        return false;
                    break;
                default:
                    return false;
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
    private boolean match(char a, char b) {
        if (a == '{' && b == '}')
            return true;
        if (a == '(' && b == ')')
            return true;
        if (a == '[' && b == ']')
            return true;
        return false;
    }
}
