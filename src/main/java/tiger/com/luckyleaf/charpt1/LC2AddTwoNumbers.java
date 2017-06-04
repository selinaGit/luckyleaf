package tiger.com.luckyleaf.charpt1;

/**
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
===================================================
 Your runtime beats 100.00 % of java submissions.
 */
public class LC2AddTwoNumbers {


    /**
     *
     *  这道题的思路和 add binary  67 很像
     1. carry += l1.val; l1 = l1.next
     2. carry += l2.val; l2 = l2.next
     3. current.next = new ListNode(carry % 10);
     4. carry /= 10
     5. if (carry!= 0), add this to current.next
     6. return dummy.next

     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry = l1.val + carry;
                l1 = l1.next; //do not forget this
            }
            if (l2 != null) {
                carry = l2.val + carry;
                l2 = l2.next; //do not forget this.
            }

            current.next = new ListNode(carry % 10);
            current = current.next;
            carry /= 10;
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
