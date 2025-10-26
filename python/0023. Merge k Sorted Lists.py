# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        return self.merge(lists, 0, len(lists) - 1)

    def mergeTwoLists(self, node1, node2):
        if node1 is None or node2 is None:
            return node1 if node1 else node2

        a, b = node1, node2
        head = ListNode(0, None)
        tail = head
        while a and b:
            if a.val < b.val:
                tail.next = a
                a = a.next
            else:
                tail.next = b
                b = b.next
            tail = tail.next
        
        tail.next = a if a else b

        return head.next

    def merge(self, lists, l, r):
        if l == r:
            return lists[l]
        if l > r:
            return None
        mid = (l + r) >> 1
        return self.mergeTwoLists(self.merge(lists, l, mid), self.merge(lists, mid + 1, r))
