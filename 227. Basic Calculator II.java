class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int num = 0;
        // set to '+', so it will always push the first number initial
        char sign = '+';
        int i = 0;
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch))num = num * 10 + Character.getNumericValue(ch);
            if((!Character.isWhitespace(ch) && !Character.isDigit(ch)) || i == s.length() - 1) {
                switch(sign) {
                    case '-':
                        stack.push(-num);
                        break;
                    case '+':
                        stack.push(num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                // update sign & reset num
                sign = ch;
                num = 0;
            }
            i ++;

        }


        for(int val : stack)result += val;
        return result;
    }
}
