public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if (num < 0 || num > 10)
            return res;
        backtracking(num, 0, new int[10], 0, res);
        return res;
    }
    private void backtracking(int num, int index, int[] cur, int count, List<String> res) {
        if (num == count) {
            // interpret
            int minute = 0;
            for (int i = 0; i <= 5; i++) {
                if (cur[i] == 1)
                    minute |= 1 << i;
            }
            if (minute >= 60)
                return;
            int hour = 0;
            for (int i = 0; i<= 3; i++) {
                if (cur[i + 6] == 1)
                    hour |= 1 << i;
            }
            if (hour >= 12)
                return;
            
            //ok
            String time = String.valueOf(hour) + ':';
            if (minute < 10)
                time += '0';
            time += String.valueOf(minute);
            res.add(time);
            return;
        }
        if (index >= 10)
            return;
        backtracking(num, index + 1, cur, count, res);
        cur[index] = 1;
        backtracking(num, index + 1, cur, count + 1, res);
        cur[index] = 0;
    }
}
