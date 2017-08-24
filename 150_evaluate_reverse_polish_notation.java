public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> nums = new Stack<>();
        for (String token : tokens) {
            if (isInteger(token))
                nums.push(Integer.parseInt(token));
            else {
                int op2 = nums.pop();
                int op1 = nums.pop();
                switch (token.charAt(0)) {
                    case '+':
                        nums.push(op1 + op2);
                        break;
                    case '-':
                        nums.push(op1 - op2);
                        break;
                    case '*':
                        nums.push(op1 * op2);
                        break;
                    case '/':
                        nums.push(op1 / op2);
                        break;
                }
            }
        }
        return nums.pop();
    }
    private boolean isInteger(String input) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }

