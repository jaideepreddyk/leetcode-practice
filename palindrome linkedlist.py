# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head) -> bool:
        # node_string=''
        # while head:
        #     node_string=node_string+str(head.val)
        #     head=head.next
        
        # if node_string==node_string[::-1]:
        #     return True
        # else:
        #     return False

     #faster array solution 
        node_list=[]
        while head:
            node_list.append(head.val)
            head=head.next

        l,r=0,len(node_list)-1
        while l<=r:
            if node_list[l]!=node_list[r]:
                return False
            l+=1
            r-=1
        return True
    
    # optimal solution time: O(n) and O(1)

    def isPalindrome(self, head) -> bool:
        fast=slow=head
        # trying to get the middle element
        while fast and fast.next: # because you are making a longer jump, it's important to check for fast.next validity
            fast=fast.next.next  # because here fast has a chance to be null, we have fast in the while on top (therefore, both needed in while)
            slow=slow.next # will get to the middle element by the time fast gets to the end

        
        # reversing from the middle
        prev=None # disconnecting at the middle so that the loop stops when running from the end
        while slow:
            temp=slow.next # holds the next element(forward pointing one)
            slow.next=prev # now the current obj's next will point backwards
            prev=slow # moving a step fowrard(this will be the new slow.next to the next obj but in reverse direction)
            slow=temp  # moving a step forward
        
        l,r=head,prev
        while r:
            if l.val!=r.val:
                return False
            l=l.next
            r=r.next
        return True
        
        



        



