public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null)
            return null;
        int[] occur = new int[26];
        for (char ch : s.toCharArray()) {
            occur[ch - 'a']++;
        }
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            occur[ch - 'a']--;
            if (visited[ch - 'a'])
                continue;
            while (!stack.isEmpty() && stack.peek() > ch && occur[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack)
            sb.append(ch);
        return sb.toString();
    }
}
