/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.math.BigDecimal;
import java.math.MathContext;
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length <= 0)
            return 0;
        if (points.length <= 2)
            return points.length;
        int res = 0;
        for (Point p1 : points) {
            Map<BigDecimal, Integer> map = new HashMap<>();
            int samex = 1;
            int samepoint = 0;
            for (Point p2 : points) {
                if (p1 != p2) {
                    if (p1.x == p2.x && p1.y == p2.y) {
                        samepoint++;
                        samex++;
                        continue;
                    }else if (p1.x == p2.x) {
                        samex++;
                        continue;
                    }
                    BigDecimal dy = new BigDecimal(p2.y - p1.y);
                    BigDecimal dx = new BigDecimal(p2.x - p1.x);
                    BigDecimal slope = dy.divide(dx, MathContext.DECIMAL128);
                    if (!map.containsKey(slope)) {
                        map.put(slope, 2);
                    } else {
                        map.compute(slope, (k, v) -> v + 1);
                    }
                    res = Math.max(res, map.get(slope) + samepoint);
                    if (res == 3)
                        System.out.println(p1.x);
                }
            }
            res = Math.max(res, samex);
        }
        return res;
    }
}
