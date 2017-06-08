package tiger.com.luckyleaf.charpt1;

/**
 *
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.

 ==================
 Your runtime beats 22.36 % of java submissions.
 */
public class LC82RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preDelete = dummy;

        while (head != null && head.next != null) {

            if (head.val != head.next.val) {
                head = head.next;
                preDelete = preDelete.next;
            } else {
                int val = head.val;
                while (head != null && head.val == val) {
                    head = head.next;
                }
                preDelete.next = head;
            }
        }
        return dummy.next;
    }
}
