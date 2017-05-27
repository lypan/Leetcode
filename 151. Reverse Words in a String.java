public class Solution {
    public String reverseWords(String s) {
        char[] chArray = s.toCharArray();
        reverse(chArray, 0, chArray.length - 1);
        reverseTheWords(chArray);
        return removeSpace(chArray);
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

    public String removeSpace(char[] str) {
        int i = 0;
        int j = 0;

        while(j < str.length) {
            while(j < str.length && str[j] == ' ')j ++;
            while(j < str.length && str[j] != ' ')str[i ++] = str[j ++];
            // check if there are still words left
            // if there are still words left, j will < str.length
            while(j < str.length && str[j] == ' ')j ++;
            if(j < str.length)str[i ++] = ' ';
        }

        return new String(str).substring(0, i);
    }
}
