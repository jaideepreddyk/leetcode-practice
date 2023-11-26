# Definition for a binary tree node.
from queue import Queue
import queue
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def mergeTrees(self, root1, root2):
        if not root1:
            return root2
        root1_list=queue.Queue()
        root2_list=queue.Queue()
        root1_list.put(root1)
        root2_list.put(root2)
        while not root1_list.empty() or not root2_list.empty():
            curr1=root1_list.get()
            curr2=root2_list.get()
            if curr1 and curr2:
                curr1.val=curr1.val+curr2.val
                if curr1.left:
                    root1_list.put(curr1.left)
                    root2_list.put(curr2.left)
                else:
                    curr1.left=curr2.left
                if curr1.right:
                    root1_list.put(curr1.right)
                    root2_list.put(curr2.right)
                else:
                    curr1.right=curr2.right
        
        return root1





# use two lists, one for each tree
# use BFS and try indexing it from the same position (none should be added too)
# if both nodes exist add the val and append both nodes left and right to their lists
# if one of them null then the other node and no appending
