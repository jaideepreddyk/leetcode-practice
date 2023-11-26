from queue import Queue
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def invertTree(self, root):
        holder=None

        if not root:
            return None

        if root.left:
            root.left=self.invertTree(root.left)
        if root.right:
            root.right=self.invertTree(root.right)
        holder=root.left
        root.left=root.right
        root.right=holder

        return root

# even smaller solution

class Solution:
    def invertTree(self, root):
        
        if not root:
            return None
        
        ## only if you do it this way older values are passed(If you do one after the other you will lose one of the subtrees)
        root.left,root.right=self.invertTree(root.right),self.invertTree(root.left)
        return root

## iterative solution (BFS)
class Solution:
    def invertTree(self, root):
        if root:
            tree_nodes=Queue()
            tree_nodes.put(root)
            while tree_nodes.queue:
                curr=tree_nodes.get()
                curr.left,curr.right=curr.right,curr.left
                if curr.left:
                    tree_nodes.put(curr.left)
                if curr.right:
                    tree_nodes.put(curr.right)

        return root
