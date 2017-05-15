/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int bufPtr = 0;
    private int bufCnt = 0;
    // buffer is used to store previous elements
    private char[] buffer = new char[4];

    public int read(char[] buf, int n) {
        int ptr = 0;

        // won't go into while loop when n == 0
        // so won't read4 buffer to replace old data
        while(ptr < n) {

            // buffer is used out, restart from the head
            if(bufPtr == 0)bufCnt = read4(buffer);

            // fill in output by using buffer
            while(ptr < n && bufPtr < bufCnt) {
                buf[ptr] = buffer[bufPtr];
                ptr ++;
                bufPtr ++;
            }

            // buffer is used out, restart from the head
            if(bufPtr == bufCnt)bufPtr = 0;
            if(bufCnt < 4)break;
        }
        return ptr;
    }
}
