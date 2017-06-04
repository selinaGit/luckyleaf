package tiger.com.luckyleaf.charpt1;

import java.util.ArrayDeque;
/**
 * http://www.lintcode.com/en/problem/min-stack/
 *
 * ================================================
 * Your runtime beats 50.22 % of java submissions.
 *
 * Use two stacks to implement
 */
public class LC155MinStackTwoStacks {

    private ArrayDeque<Integer> stack = new ArrayDeque<>();
    private ArrayDeque<Integer> minStack = new ArrayDeque<>();


    public void push(int x) {
        if (minStack.isEmpty() || minStack.peekFirst() >= x) {
            minStack.addFirst(x);
        }
        stack.addFirst(x);
    }

    public void pop() {
        int num = stack.pop();
        int min = minStack.peekFirst();

        if (num == min) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack != null) {
            return stack.peekFirst();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public int getMin() {
        if (minStack != null) {
            return minStack.peekFirst();
        } else {
            return Integer.MAX_VALUE;
        }

    }
}
