public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null)
            return res;
        
        // corner case, s is valid
        if (isValid(s)) {
            res.add(s);
            return res;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (visited.contains(temp))
                    continue;
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) != '(' && temp.charAt(j) != ')')
                        continue;
                    String sub = temp.substring(0, j) + temp.substring(j+1, temp.length());
                    if (isValid(sub)) {
                        if (!set.contains(sub)) {
                            res.add(sub);
                            set.add(sub);
                        }
                    } else {
                        queue.offer(sub);
                    }
                }
                visited.add(temp);
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
