public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null)
            return new int[0];
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.offer(i);
        
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            res.add(temp);
            for (int point : graph.get(temp)) {
                indegree[point]--;
                if (indegree[point] == 0) {
                    queue.offer(point);
                }
            }
        }
        if (res.size() == numCourses) {
            return res.stream().mapToInt(i->i).toArray();
        } else {
            return new int[0];
        }
    }
}
