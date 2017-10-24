/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head;
        RandomListNode next;
        RandomListNode pseudoHead = new RandomListNode(0);
        // 1.contruct copy node list
        while(iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }
        // 2.assign copy random list
        iter = head;
        while(iter != null) {
            // random.next because should point to copy node not original
            // random may be null
            if(iter.random != null)iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        // 3.separate copy node list
        RandomListNode copyIter = pseudoHead;
        iter = head;
        while(iter != null) {
            // connect copy node in the copy list
            copyIter.next = iter.next;
            copyIter = copyIter.next;
            // move original node next to original state
            iter.next = iter.next.next;
            iter = iter.next;
        }

        return pseudoHead.next;
    }
}
