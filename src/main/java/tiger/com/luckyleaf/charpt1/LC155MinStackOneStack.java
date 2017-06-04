package tiger.com.luckyleaf.charpt1;

import java.util.ArrayDeque;

/**
 *
 * https://leetcode.com/problems/min-stack/#/description
 *
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
====================================================
 Your runtime beats 94.32 % of java submissions.

 Use One Stack to implement

 */
public class LC155MinStackOneStack {

    private ArrayDeque<Integer> stack = new ArrayDeque<>();
    private int min = Integer.MAX_VALUE;

    // if input is smaller than current stack, add current min to Stack
    // add then push x to stack
    public void push(int x) {
        if (x <= min) {
            stack.addFirst(min);
            min = x;
        }
        stack.addFirst(x);
    }

    // if current pop out value is the min, pop out the next min number and set it to min
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return min;
    }
}
