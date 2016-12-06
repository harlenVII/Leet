public class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
            
        int start = 1, end = x;
        while (start + 1 < end){
            int middle = start + (end - start) / 2;
            if (middle > x / middle)
                end = middle;
            else
                start = middle;
        }
        
        if (end <= x / end)
            return end;
        else
            return start;
    }
}
