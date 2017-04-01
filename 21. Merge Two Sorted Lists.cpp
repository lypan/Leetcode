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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* dummyRoot = new ListNode(0);
        ListNode * currentListEnd = dummyRoot;

        while(l1 != NULL && l2 != NULL) {
            int v1 = l1->val;
            int v2 = l2->val;

            if(v1 <= v2) {
                currentListEnd->next = l1;
                l1 = l1->next;
            }
            else {
                currentListEnd->next = l2;
                l2 = l2->next;
            }
            currentListEnd = currentListEnd->next;
        }

        // l2 has remaining elements
        if(l1 == NULL)currentListEnd->next = l2;
        else currentListEnd->next = l1;


        return dummyRoot->next;
    }
};


// sol2
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// class Solution {
// public:
//     ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
//         if(l1 == NULL)return l2;
//         if(l2 == NULL)return l1;
//
//         int v1 = l1->val;
//         int v2 = l2->val;
//
//         ListNode* dummyRoot = new ListNode(0);
//
//         if(v1 <= v2) {
//             dummyRoot->next = l1;
//             l1->next = mergeTwoLists(l1->next, l2);
//         }
//         else {
//             dummyRoot->next = l2;
//             l2->next = mergeTwoLists(l1, l2->next);
//         }
//
//         return dummyRoot->next;
//     }
// };
