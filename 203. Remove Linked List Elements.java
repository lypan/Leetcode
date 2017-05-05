/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)return null;

        if(head.val == val)return removeElements(head.next, val);
        else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
// sol2
// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
// public class Solution {
//     public ListNode removeElements(ListNode head, int val) {
//         ListNode fakeHead = new ListNode(-1);
//         fakeHead.next = head;
//         ListNode prev = fakeHead;
//         ListNode cur = head;
//
//         while(cur != null) {
//             if(cur.val == val) {
//                 prev.next = cur.next;
//             }
//             else {
//                 prev = prev.next;
//             }
//             cur = cur.next;
//         }
//
//         return fakeHead.next;
//     }
// }
