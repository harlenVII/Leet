class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return "";
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            if (str.equals(".") || str.isEmpty())
                continue;
            if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else
                stack.push(str);
        }
        return "/" + String.join("/", stack);
    }
}
