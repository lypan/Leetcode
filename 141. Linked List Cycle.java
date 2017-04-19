/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)return false;

        ListNode walker = head;
        ListNode runner = head;

        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;

            if(walker == runner)return true;
        }

        return false;
    }
}

// reference:http://www.geeksforgeeks.org/write-a-c-function-to-detect-loop-in-a-linked-list/

// sol2
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         Set<ListNode> nodesSeen = new HashSet<>();
//         while (head != null) {
//             if (nodesSeen.contains(head)) {
//                 return true;
//             } else {
//                 nodesSeen.add(head);
//             }
//             head = head.next;
//         }
//         return false;
//     }
// }
