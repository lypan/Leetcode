public class MyStack {
    private Queue<Integer> queue1;
    private int top;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue1.size();
        queue1.add(x);
        //
        for(int i = 0; i < size; i ++){
            int val = queue1.remove();
            queue1.add(val);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue1.element();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// sol2
// public class MyStack {
//     private Queue<Integer> queue1;
//     private Queue<Integer> queue2;
//     private Queue<Integer> temp;
//     private int top;
//     /** Initialize your data structure here. */
//     public MyStack() {
//         queue1 = new LinkedList<Integer>();
//         queue2 = new LinkedList<Integer>();
//         temp = new LinkedList<Integer>();
//     }
//
//     /** Push element x onto stack. */
//     public void push(int x) {
//         top = x;
//         queue1.add(top);
//     }
//
//     /** Removes the element on top of the stack and returns that element. */
//     public int pop() {
//         while(queue1.size() > 1) {
//             top = queue1.remove();
//             queue2.add(top);
//         }
//         int popVal = queue1.remove();
//         temp = queue1;
//         queue1 = queue2;
//         queue2 = temp;
//         return popVal;
//     }
//
//     /** Get the top element. */
//     public int top() {
//         return top;
//     }
//
//     /** Returns whether the stack is empty. */
//     public boolean empty() {
//         return queue1.isEmpty();
//     }
// }
//
// /**
//  * Your MyStack object will be instantiated and called as such:
//  * MyStack obj = new MyStack();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.top();
//  * boolean param_4 = obj.empty();
//  */
