public class Solution {
    public int calculate(String s) {
        if (s == null)
            return 0;
        char[] cs = s.toCharArray();
        List<Character> operators = new ArrayList<>();
        List<Integer> operands = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ')
                continue;
            if (cs[i] == '+' || cs[i] == '-' || cs[i] == '*' || cs[i] == '/')
                operators.add(cs[i]);
            else {
                String temp = "";
                while (i <  cs.length && cs[i] >= '0' && cs[i] <= '9') {
                    temp += cs[i];
                    i++;
                }
                i--;
                int op2 = Integer.valueOf(temp);
                if (!operators.isEmpty()) {
                    char oprd = operators.get(operators.size() - 1);
                    if (oprd == '*' || oprd == '/') {
                        int op1 = operands.remove(operands.size() - 1);
                        operators.remove(operators.size() - 1);
                        if (oprd == '*')
                            operands.add(op1 * op2);
                        else
                            operands.add(op1 / op2);
                    } else {
                        operands.add(op2);
                    }
                } else {
                    operands.add(op2);
                }
            }
        }
        int op1 = operands.get(0);
        for (int i = 0; i < operators.size(); i++) {
            int op2 = operands.get(i+1);
            if (operators.get(i) == '+')
                op1 += op2;
            else
                op1 -= op2;
        }
        return op1;
    }
}
