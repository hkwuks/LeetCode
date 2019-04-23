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
        ListNode *s=new ListNode(0);
        ListNode *p=s;
        int flag=0;
        while(l1!=NULL&&l2!=NULL){
            int temp=l1->val+l2->val;
            if(flag==1){
                temp+=1;
                flag=0;
            }
            if(temp>9){
                flag=1;
                temp%=10;
            }
            ListNode *q=new ListNode(temp);
            p->next=q;
            p=p->next;
            l1=l1->next;
            l2=l2->next;
        }
        while(l1!=NULL){
            int temp=l1->val;
            if(flag==1){
                temp+=1;
                flag=0;
            }
            if(temp>9){
                temp%=10;
                flag=1;
            }
            ListNode *q=new ListNode(temp);
            p->next=q;
            p=p->next;
            l1=l1->next;
        }
        while(l2!=NULL){
            int temp=l2->val;
            if(flag==1){
                temp+=1;
                flag=0;
            }
            if(temp>9){
                temp%=10;
                flag=1;
            }
            ListNode *q=new ListNode(temp);
            p->next=q;
            p=p->next;
            l2=l2->next;
        }
        if(flag==1){
            ListNode *q=new ListNode(1);
            p->next=q;
            p=p->next;
        }
        return s->next;
    }
};