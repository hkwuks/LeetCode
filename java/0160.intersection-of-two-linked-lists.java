/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            visited.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while(tmp != null){
            if(visited.contains(tmp)){
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
}

class Solution{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode i = headA, j = headB;
        while(i != j){
            i = i == null ? headB : i.next;
            j = j == null ? headA : j.next;
        }
        return i;
    }
}