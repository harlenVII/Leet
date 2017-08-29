class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        // corner case, s is valid
        if (isValid(s)) {
            res.add(s);
            return res;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (visited.contains(temp))
                    continue;
                visited.add(temp);
                if (isValid(temp)) {
                    res.add(temp);
                    System.out.println("1");
                } else {
                    for (int j = 0; j < temp.length(); j++) {
                        if (temp.charAt(j) !='(' && temp.charAt(j) !=')')
                            continue;
                        String sub = temp.substring(0, j) + temp.substring(j + 1);
                        queue.offer(sub);
                    }
                }
            }
            if (res.size() > 0)
                break;
        }
        return res;
    }
    private boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                count++;
            else if (ch == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}
