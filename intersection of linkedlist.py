# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:

        currA=headA
        a_list=[headA]
        while currA.next is not None:
            a_list.append(currA.next)
            currA=currA.next

        currB=headB
        b_list=[headB]
        while currB.next is not None:
            b_list.append(currB.next)
            currB=currB.next
        
        setA=set(a_list)
        setB=frozenset(b_list)
        common_nodes=[x for x in a_list if x in setB]


        if common_nodes:
            return common_nodes[0]
