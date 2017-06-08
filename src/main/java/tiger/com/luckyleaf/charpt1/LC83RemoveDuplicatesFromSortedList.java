package tiger.com.luckyleaf.charpt1;

/**
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 ==============================================
 Your runtime beats 17.83 % of java submissions.
 */
public class LC83RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head.next;
        ListNode second = head;

        while (first != null) {
            if (first.val == second.val) {
                second.next = first.next;
                first = second.next;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        return head;
    }

    // https://discuss.leetcode.com/topic/14775/3-line-java-recursive-solution
    // need to understand this more!!!
    // very neat code
    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicatesRecursive(head.next);
        //how to delete the duplicated node
        return head.val == head.next.val ? head.next : head;
    }
}
