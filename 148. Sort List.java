/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;

        // 1.split it into 2 halves
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;

        while(fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // add null to separate two list
        temp.next = null;

        // 2. sort each half
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(slow);
        // 3. merge
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode finalHead = new ListNode(0);
        ListNode iter = finalHead;

        finalHead.next = null;

        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                iter.next = head1;
                head1 = head1.next;
            }
            else {
                iter.next = head2;
                head2 = head2.next;
            }
            iter = iter.next;
        }

        if(head1 == null) {
            iter.next = head2;
        }
        else {
            iter.next = head1;
        }

        return finalHead.next;
    }
}
