class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return 0;
        if (n == 0)
            return tasks.length;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks)
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        pq.addAll(map.entrySet());
        int res = 0;
        while (!pq.isEmpty()) {
            int times = Math.min(n + 1, pq.size());
            for (int i = 0; i < times; i++) {
                Map.Entry<Character, Integer> entry = pq.poll();
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() != 0)
                    list.add(entry);
            }
            pq.addAll(list);
            list.clear();
            if (!pq.isEmpty())
                res += n + 1;
            else
                res += times;
        }
        return res;
    }
}
