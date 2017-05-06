/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // odd number of nodes in list
        // move slow away from the middle node
        if(fast != null)slow = slow.next;

        ListNode reverseHead = reverseList(slow);

        // compare two half list
        while(reverseHead != null){
            if(head.val != reverseHead.val)return false;
            head = head.next;
            reverseHead = reverseHead.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }
}
