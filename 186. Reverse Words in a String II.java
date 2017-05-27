public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseTheWords(s);
    }

    public void reverse(char[] str, int start, int end) {
        char temp;
        while(start <= end) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start ++;
            end --;
        }
    }

    public void reverseTheWords(char[] str) {
        int i = 0;
        int j = 0;

        while(i < str.length) {
            while(i < str.length && str[i] == ' ')i ++;
            j = i;
            while(j < str.length && str[j] != ' ')j ++;
            reverse(str, i, j - 1);
            i = j;
        }
    }
}
