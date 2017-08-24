/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null || buf.length < n)
            return -1;
        char[] temp = new char[4];
        int p = 0;
        boolean eof = false;
        
        while (!eof && p < n) {
            int len = read4(temp);
            if (len < 4)
                eof = true;
            len = Math.min(len, n - p);
            for (int i = p; i < p + len; i++)
                buf[i] = temp[i - p];
            p += len;
        }
        return p;
    }
}
