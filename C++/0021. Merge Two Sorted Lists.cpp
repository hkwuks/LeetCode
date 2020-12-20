/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(!l1) return l2;
        if(!l2) return l1;
        ListNode *p=l1,*q=l2;
        ListNode *l;
        if(p->val<=q->val){
            l=p;
            p=p->next;
        }
        else {
            l=q;
            q=q->next;
        }
        ListNode *t=l;
        while(p&&q){
            if(p->val<=q->val){
                t->next=p;
                t=t->next;
                p=p->next;
            }
            else{
                t->next=q;
                t=t->next;
                q=q->next;
            }
        }
        if(p)
            t->next=p;
        if(q)
            t->next=q;
        return l;
    }
};