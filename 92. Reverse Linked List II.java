/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = head;

        for(int i = 0; i < m - 1; i ++) {
            prev = prev.next;
            cur = cur.next;
        }

        ListNode headNode = prev;
        ListNode tailNode = cur;
        // 1. reverse middle sublist
        for(int i = m; i <= n; i ++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // 2. connect head and tail node
        headNode.next = prev;
        tailNode.next = cur;


        return dummyHead.next;
    }
}
