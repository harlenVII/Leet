/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] left = new char[4];
    int leftLen = 0;
    public int read(char[] buf, int n) {
        if (buf == null || buf.length < n)
            return -1;
        char[] temp = new char[4];
        int p = 0;
        boolean eof = false;
        
        // copy from left
        if (leftLen <= n) {
            for (int i = 0; i < leftLen; i++)
                buf[i] = left[i];
            p += leftLen;
            leftLen = 0;
        } else {
            for (int i = 0; i < n; i++)
                buf[i] = left[i];
            for (int i = n; i < leftLen; i++)
                left[i - n] = left[i];
            leftLen -= n;
            return n;
        }
        
        while (!eof && p < n) {
            int len = read4(temp);
            if (len < 4)
                eof = true;
            if (n - p < len) {
                for (int i = 0; i < len - n + p; i++)
                    left[i] = temp[n - p + i];
                leftLen = len - n + p;
                len = Math.min(len, n - p);
            }
            for (int i = p; i < p + len; i++)
                buf[i] = temp[i - p];
            p += len;
        }
        return p;
    }
}
