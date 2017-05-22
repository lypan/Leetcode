public class MinStack {
    Stack<Integer> allStack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        allStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        if(allStack.empty()) {
            allStack.push(x);
            minStack.push(x);
        }
        else {
            allStack.push(x);
            // equal still has to push one more duplicate
            if(x <= minStack.peek())minStack.push(x);
        }
    }

    public void pop() {
        int val = allStack.pop();
        if(val == minStack.peek())minStack.pop();
    }

    public int top() {
        return allStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
