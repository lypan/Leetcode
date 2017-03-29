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
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == NULL)return NULL;

        ListNode* prev = head;
        ListNode* cur = head;

        // loop except last node
        while(cur->next) {
            if(cur->val != prev->val) {
                prev->next = cur;
                prev = cur;
            }
            cur = cur->next;
        }
        //check last node is duplicate or not
        if(prev->val ==cur->val)prev->next = NULL;
        else prev->next = cur;

        return head;
    }
};


// sol2
// /**
//  * Definition for singly-linked list.
//  * struct ListNode {
//  *     int val;
//  *     ListNode *next;
//  *     ListNode(int x) : val(x), next(NULL) {}
//  * };
//  */
// class Solution {
// public:
//     ListNode* deleteDuplicates(ListNode* head) {
//         ListNode *current = head;
//         while(current != NULL && current->next != NULL) {
//             // advance current node's next one step
//             if(current->next->val == current->val) {
//                 current->next = current->next->next;
//             }
//             // move current node pointer to next different value's node
//             else {
//                 current = current->next;
//             }
//         }
//
//         return head;
//     }
// };
