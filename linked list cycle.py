class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head) -> bool:

        ########### MY O(n*n) solution
        # node_list=[head]
        # curr_node=head

        # while curr_node.next:
        #     if curr_node.next in node_list:
        #         return True
        #     else:
        #         node_list.append(curr_node.next)
        #         curr_node=curr_node.next
            
        # return False

    ############### MY O(n) solution

        node_dict={}
        node_dict[head]=0
        counter=0
        curr_node=head

        while curr_node.next:
            if node_dict[curr_node.next]:
                return True
            else:
                counter=counter+1
                node_dict[curr_node.next]=counter
                curr_node=curr_node.next
        
        return False



############ O(1) solution

    def hasCycle(self, head):
        try:                 ### try-except block is to avoid checking if node.next exists
            slow = head
            fast = head.next
            while slow is not fast:
                slow = slow.next
                fast = fast.next.next
            return True
        except:
            return False
