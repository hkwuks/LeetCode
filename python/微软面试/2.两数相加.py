# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next



class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if l1==None:
            return l2
        if l2==None:
            return l1
        flag,t = self.add(l1.val,l2.val,0)
        head=t
        l1 = l1.next
        l2 = l2.next
        while True:
            if l1 == None and l2 == None and flag == 0:
                return head
            elif l1 == None and l2 == None:
                flag, t.next = self.add(0, 0, flag)
                t=t.next
            elif l1 == None:
                flag, t.next = self.add(0, l2.val, flag)
                l2=l2.next
                t=t.next
            elif l2 == None:
                flag, t.next = self.add(l1.val, 0, flag)
                l1=l1.next
                t=t.next
            else:
                flag,t.next = self.add(l1.val,l2.val,flag)
                l1=l1.next
                l2=l2.next
                t=t.next
                
    def add(self, a, b, flag):
        if a+b+flag > 9:
            return 1, ListNode(a+b+flag-10)
        else:
            return 0, ListNode(a+b+flag)