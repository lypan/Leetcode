/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        ListNode next = null;
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        int sum = 0;
        int carry = 0;

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        while(!s1.empty() || !s2.empty()) {
            if(!s1.empty())sum += s1.pop();
            if(!s2.empty())sum += s2.pop();
            sum += carry;
            carry = sum / 10;

            current = new ListNode(sum % 10);
            dummyHead.next = current;
            current.next = next;
            next = current;

            sum = 0;
        }

        if(carry == 1){
            current = new ListNode(1);
            dummyHead.next = current;
            current.next = next;
        }

        return dummyHead.next;
    }
}
