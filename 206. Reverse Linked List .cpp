/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 
// iterative version
//  class Solution {
// public:
//     ListNode* reverseList(ListNode* head) {
//         ListNode* prev = NULL;
//         ListNode* cur = head;
//         while(cur != NULL) {
//             ListNode* temp = cur->next;
//             cur->next = prev;
//             prev = cur;
//             cur = temp;
//         }
//         return prev;
//     }
// };

// recursive version
// class Solution {
// public:
//     ListNode* reverseList(ListNode* head) {
//         if(head == NULL || head->next == NULL)return head;
//         ListNode* temp = reverseList(head->next);
//         head->next->next = head;
//         head->next = NULL;
//         return temp;
//     }
// };

//  stack version
// class Solution {
// public:
//     ListNode* reverseList(ListNode* head) {
//         if(head == NULL) return head;
//         stack<ListNode*> linkStack;
//         ListNode* current = head;
//         while(current != NULL) {
//             linkStack.push(current);
//             current = current->next;
//         }
//         head = linkStack.top();
//         linkStack.pop();
//         current = head;
//         while(!linkStack.empty()) {
//             current->next = linkStack.top();
//             linkStack.pop();
//             current = current->next;
//         }
//         current->next = NULL;
//         return head;
//     }
// };