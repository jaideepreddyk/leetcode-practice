# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
        

    def maxDepth(self, root: TreeNode) -> int:
        max_depth,pos=self.depthHelper(root,1,1)
        return max_depth
    
    def depthHelper(self,start,max,curr):

        if start is None:
            return 0,0
        if curr>max:
            max=curr
        if start.left:
            curr=curr+1
            max,curr=self.depthHelper(start.left,max,curr)
            curr=curr-1
        if start.right:
            curr=curr+1
            max,curr=self.depthHelper(start.right,max,curr)
            curr=curr-1
        return max,curr


### DEPTH FIRST SEARCH - DFS Solution (Very smart solution) found on Leetcode
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        queue = [root]
        depth = 0
        while queue:
            depth += 1
            for i in range(len(queue)):
                cur_root = queue.pop(0)
                if cur_root.left:
                    queue.append(cur_root.left)
                if cur_root.right:
                    queue.append(cur_root.right)
        return depth

        


root=TreeNode(1)
root.left=TreeNode(2)
root.right=TreeNode(2)
root.left.left=TreeNode(3)
root.left.right=TreeNode(4)
root.right.right=TreeNode(3)
root.right.left=TreeNode(4)


s=Solution()
print(s.maxDepth(root))

## depth default value is 1 for the root node
## add 'depth' argument 
## recursively depth+1
## return depth
