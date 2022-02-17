/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head = new ListNode();
        ListNode i = list1, j = list2;
        if(i.val <= j.val){
            head = i;
            i = i.next;
        }else {
            head = j;
            j = j.next;
        }
        ListNode p = head;
        while (i != null && j != null) {
            if(i.val <= j.val){
                p.next = i;
                i = i.next;
            }else{
                p.next = j;
                j = j.next;
            }
            p = p.next;
        }
        if(i!=null){
            p.next = i;
        }
        if(j!=null){
            p.next = j;
        }
        return head;
    }
}