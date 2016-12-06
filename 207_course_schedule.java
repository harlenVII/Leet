public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null)
            return false;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) 
            graph.add(new ArrayList<Integer>());
        
        int[] indegree = new int[numCourses];
        
        for(int[] pair : prerequisites) {
            indegree[pair[0]]++;
            graph.get(pair[1]).add(pair[0]);    
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);
                
        int count = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count++;
            for (int edge : graph.get(temp)) {
                indegree[edge]--;
                if (indegree[edge] == 0)
                    queue.offer(edge);
            }
        }
        return count == numCourses;
    }
}
