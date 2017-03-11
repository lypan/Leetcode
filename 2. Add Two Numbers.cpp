/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
        ListNode* dummyHead = new ListNode(0);
        ListNode* current = dummyHead;
        int carry = 0;
        int sum = 0;
        while(l1 || l2) {
            int val1 = l1 ? l1->val : 0;
            int val2 = l2 ? l2->val : 0;

            sum = val1 + val2 + carry;
            carry = sum / 10;

            current->next = new ListNode(sum % 10);
            current = current->next;
            
            l1 = l1 ? l1->next : NULL;
            l2 = l2 ? l2->next : NULL;
        }
        if(carry) {
            current->next = new ListNode(carry);
        }
        
        return dummyHead->next;
    }
};
// Thought
1.sum and carry
2.number is too big, cannot just sum
3.don't modify dummhead values