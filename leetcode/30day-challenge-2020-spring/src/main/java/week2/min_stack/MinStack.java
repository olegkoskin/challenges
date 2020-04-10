package week2.min_stack;

/**
 * Min Stack.
 * </p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * </p>
 * <ul>
 *     <li>push(x) -- Push element x onto stack.</li>
 *     <li>pop() -- Removes the element on top of the stack.</li>
 *     <li>top() -- Get the top element.</li>
 *     <li>getMin() -- Retrieve the minimum element in the stack.</li>
 * </ul>
 *
 * </p>
 * <b>Example:</b>
 * <pre>
 * <code>MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * </code>
 * </pre>
 *
 * </p>
 * <b>Hint: </b> Consider each node in the stack having a minimum value. (Credits to @aakarshmadhavan)
 */
public class MinStack {

    private Node top;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        int min = top == null ? x : Math.min(x, top.getMin());
        top = new Node(x, top, min);
    }

    public void pop() {
        top = top.getPrev();
    }

    public int top() {
        return top.getVal();
    }

    public int getMin() {
        return top.getMin();
    }

    static class Node {
        int val;
        Node prev;
        int min;

        public Node(int val, Node prev, int min) {
            this.val = val;
            this.prev = prev;
            this.min = min;
        }

        public int getVal() {
            return val;
        }

        public Node getPrev() {
            return prev;
        }

        public int getMin() {
            return min;
        }
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
