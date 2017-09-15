class Solution {
    // To solve this DP problem:
    // If there's no constraint, we choose min cost for each house.
    // Since house[i] and house[i - 1] cannot have the same color j, we should choose 2nd min color for house[i - 1].
    // If we choose the 3rd min color for house[i - 1], we might miss potential min cost.
    // min(i) = min(cost[i][j] + 1st min / 2nd min), 0 < j < n.
    // Since current row only relies on last row for getting mins and avoiding same color, O(1) space is enough.
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int min1 = 0, min2 = 0, index = -1;
        for (int i = 0; i < costs.length; i++) {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx = -1;
            for (int j = 0; j < costs[i].length; j++) {
                int cost = costs[i][j] + (j == index ? min2 : min1);
                if (cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    idx = j;
                } else if (cost < m2) {
                    m2 = cost;
                }
            }
            min1 = m1;
            min2 = m2;
            index = idx;
        }
        return min1;
    }
}
