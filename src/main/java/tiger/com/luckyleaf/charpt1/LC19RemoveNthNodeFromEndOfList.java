package tiger.com.luckyleaf.charpt1;

/**
 *
 * Reference: https://leetcode.com/problems/remove-nth-node-from-end-of-list/#/description
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.

 ===============================================
 Your runtime beats 84.62 % of java submissions.
 */
public class LC19RemoveNthNodeFromEndOfList {

    /**
     *
     * 注意思路和code 的简洁度
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // leetcode 在 n == 0 的时候， 会在second.next = second.next.next; throw null exception， 是错的哦。
        if (head == null || n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        while (n-- > 0) {
            //this mean the n > size of List
            if (first == null) {
                return head;
            }
            first = first.next;
        }

        //要想清楚这里
        // dummy - 6 - 5 - 4- 3 - 2 - 1
        // the distant between first and second is n, EX: 3
        // my second need to point to 4, and then I can delete 3, so I need first is stop at 1 not null !!!
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        if (second.next != null) {
            second.next = second.next.next;
        }
        return dummy.next;
    }
}
