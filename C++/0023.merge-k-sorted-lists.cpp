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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size()==0)
            return NULL;
        vector<int> num;
        for(int i=0;i<lists.size();++i){
            ListNode *p=lists[i];
            while(p!=NULL){
                num.push_back(p->val);
                p=p->next;
            }
        }
        if(num.size()==0)
            return NULL;
        sort(num.begin(),num.end());
        ListNode*l1,*l2=NULL;
        for(int i=num.size()-1;i>=0;i--)
        {
            l1=new ListNode(num[i]);
            l1->next=l2;
            l2=l1;
        }
        return l1;
    }
};