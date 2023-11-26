# Definition for singly-linked list.
from typing import Counter


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head, n: int):
        node_list=[head]
        curr=head
        while curr.next:
            node_list.append(curr.next)
            curr=curr.next
        
        if len(node_list)==n:
            head=head.next
        else:
            node_list[-(n+1)].next=node_list[-n].next

        return head
    
        