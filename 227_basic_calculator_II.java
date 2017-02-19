public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] cs = s.toCharArray();
        Deque<Character> operands = new LinkedList<>();
        Deque<Integer> operators = new LinkedList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '+' || cs[i] == '-' || cs[i] == '*' || cs[i] == '/') {
                operands.offerLast(cs[i]);
            } else if (Character.isDigit(cs[i])) {
                int num = 0;
                while (i < cs.length && Character.isDigit(cs[i])) {
                    num = num * 10 + cs[i] - '0';
                    i++;
                }
                i--;
                if (!operators.isEmpty()) {
                    char oprd = operands.peekLast();
                    if (oprd == '*' || oprd == '/') {
                        operands.pollLast();
                        int op1 = operators.pollLast();
                        if (oprd == '*')
                            operators.addLast(op1 * num);
                        else
                            operators.addLast(op1 / num);
                    } else { // don't miss me
                        operators.offerLast(num);
                    }
                } else {
                    operators.offerLast(num);
                }
            }
        }
        int op1 = operators.pollFirst();
        while (!operators.isEmpty()) {
            char oprd = operands.pollFirst();
            int op2 = operators.pollFirst();
            if (oprd == '+')
                op1 += op2;
            else
                op1 -= op2;
        }
        return op1;
    }
}
