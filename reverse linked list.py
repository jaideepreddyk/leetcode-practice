# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class LinkedList:
    def __init__(self,head=None) -> None:
        self.head=head
    
    def add(self,val):
        if not self.head:
            self.head=ListNode(val)
        else:
            curr=self.head
            while curr.next:
                curr=curr.next
            curr.next=ListNode(val)
    
    def return_head(self):
        return self.head    


class Solution:
    def reverseList(self, head):
        list_nodes=[]
        curr=head
        while curr:
            list_nodes.append(curr.val)
            curr=curr.next

        # ll=LinkedList()
        # while list_nodes:
        #     ll.add(list_nodes.pop())
        
        # return ll.return_head()
        if list_nodes:
            rev_head=ListNode(list_nodes.pop())
            curr_rev=rev_head
            while list_nodes:
                curr_rev.next=ListNode(list_nodes.pop())
                curr_rev=curr_rev.next
            return rev_head
            
            
            
        