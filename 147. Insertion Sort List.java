/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)return head;

        ListNode dummyHead = new ListNode(0);
        ListNode current = head;
        ListNode prev = dummyHead;
        // key: we move original node to the dummyHead list
        // dummyHead.next = head;

        while(current != null) {
            // store the current next first
            ListNode nextNode = current.next;
            // find the right place
            while(prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            // insert the value into
            current.next = prev.next;
            prev.next = current;

            // reset prev
            prev = dummyHead;
            current = nextNode;
        }

        return dummyHead.next;
    }
}
