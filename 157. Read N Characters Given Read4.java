/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int totalChar = 0;

        while(true) {
            int readCount = read4(temp);
            // 1.have already read more than n characters
            // 2.not enough character to read n characters
            int allowedReadCount = Math.min(n - totalChar, readCount);

            for(int i = 0; i < allowedReadCount; i ++)buf[totalChar + i] = temp[i];
            totalChar += allowedReadCount;

            // read < 4 means the 2 cases happen
            if(allowedReadCount < 4)break;
        }

        return totalChar;
    }
}
