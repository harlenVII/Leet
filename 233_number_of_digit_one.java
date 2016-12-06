public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        if (n <= 9)
            return 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(9, 1);
        for (int i = 9; i < Integer.MAX_VALUE / 10; i = i * 10 + 9) {
            map.put(i* 10 + 9, map.get(i) * 10 + i + 1); 
        }
        int weight = 1;
        int nn = n;
        while (nn / 10 != 0) {
            nn /= 10;
            weight *= 10;
        }
        int result = 0;
        result += map.get(weight - 1) * (n / weight);
        if (n / weight > 1) {
            result += weight;
        } else if (n / weight == 1) {
            result += n % weight + 1;
        }
        result += countDigitOne(n % weight);
        return result;
    }
}
