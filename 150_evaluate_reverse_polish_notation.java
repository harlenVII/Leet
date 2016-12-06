public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return -1;
        Stack<String> stack = new Stack<>();
        for (String string : tokens) {
            int op1, op2;
            if (string.length() != 1) {
                stack.push(string);
                continue;
            }
            switch (string.charAt(0)) {
                case '+':
                    op2 = Integer.parseInt(stack.pop());
                    op1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(op1 + op2));
                    break;
                case '-':
                    op2 = Integer.parseInt(stack.pop());
                    op1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(op1 - op2));
                    break;
                case '*':
                    op2 = Integer.parseInt(stack.pop());
                    op1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(op1 * op2));
                    break;
                case '/':
                    op2 = Integer.parseInt(stack.pop());
                    op1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(op1 / op2));
                    break;
                default:
                    stack.push(string);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
