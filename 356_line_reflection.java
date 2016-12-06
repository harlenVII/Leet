public class Solution {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            max = Math.max(max, x);
            min = Math.min(min, x);
            set.add(x + "." + y);
        }
        int sum = max + min;
        for (int[] point : points) {
            if (!set.contains(sum - point[0] + "." + point[1]))
                return false;
        }
        return true;
    }
}
