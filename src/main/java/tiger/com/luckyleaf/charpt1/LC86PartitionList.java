package tiger.com.luckyleaf.charpt1;

/**
 *
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 =========================================================
 * Your runtime beats 7.78 % of java submissions.    1ms
 */
public class LC86PartitionList {


    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode smallCurrent = smallDummy;
        ListNode largeCurrent = largeDummy;

        while (head != null) {
            if(head.val < x) {
                smallCurrent.next = head;
                smallCurrent = smallCurrent.next;
            } else {
                largeCurrent.next = head;
                largeCurrent = largeCurrent.next;
            }
            head = head.next;
        }
        //very important, the largeCurrent might point to someother note.
        //9 -> 1
        largeCurrent.next = null;
        smallCurrent.next = largeDummy.next;
        return smallDummy.next;
    }
}
