package tiger.com.luckyleaf.charpt1;

import java.util.LinkedList;

/**
 *
 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * ================================
 Your runtime beats 47.43 % of java submissions.
 */
public class LC173BinarySearchTreeIterator {


    /**
     *
     * This solution is very easy to understand
     *
     * 1. initial : push all lefts
     * 2. next()
     *    pop all the top and push all right of the poped node
     *    return the poped node value
     */
    private LinkedList<TreeNode> stack;;

    // put the node and all the left node to stack
    public LC173BinarySearchTreeIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        pushAllLeft(root);
    }

    /** @return whether we have a next smallest number */
    // check if the stack is empty
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    // next is poped out node and then push all the right node of the poped note to stack
    public int next() {
        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            pushAllLeft(node.right);
            return node.val;
        }
        return Integer.MIN_VALUE;
    }

    // push all node and its left nodes to stack
    public void pushAllLeft(TreeNode current) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }
}
