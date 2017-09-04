class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        String[] tmp = logs.get(0).split(":");
        stack.push(Integer.parseInt(tmp[0]));
        int last = Integer.parseInt(tmp[2]);
        
        for (int i = 1; i < logs.size(); i++) {
            tmp = logs.get(i).split(":");
            int id = Integer.parseInt(tmp[0]);
            int time = Integer.parseInt(tmp[2]);
            if (tmp[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += time - last;
                stack.push(id);
                last = time;
            } else {
                res[id] += time - last + 1;
                stack.pop();
                last = time + 1;
            }
        }
        return res;
    }
}
