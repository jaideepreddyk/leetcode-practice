# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sortedArrayToBST(self, nums) -> TreeNode:

        if len(nums)==1:
            return TreeNode(nums(0))
        if len(nums)==2:
            root=TreeNode(nums[0])
            root.left=TreeNode(nums[1])
            return root
        mid_idx=int(len(nums)/2)
        if len(nums)>=3:
            root=TreeNode(nums[mid_idx])
            root.left=TreeNode(nums[mid_idx-1])
            root.right=TreeNode(nums[-1])

            left_subtree=nums[0:mid_idx-1]
            right_subtree=nums[mid_idx+1:-1]

            curr_left=root.left
            curr_right=root.right

            while left_subtree:
                if left_subtree:
                    curr_left.left=TreeNode(left_subtree.pop())
                if left_subtree:
                    curr_left.right=TreeNode(left_subtree.pop())
                if curr_left.left:
                    curr_left=curr_left.left
            

            while right_subtree:
                if right_subtree:
                    curr_right.left=TreeNode(right_subtree.pop(0))
                if right_subtree:
                    curr_right.right=TreeNode(right_subtree.pop(0))
                if curr_right.left:
                    curr_right=curr_right.left
            
            return root
            

s=Solution()


# take the middle element as root
# mid-1:left
# mid+1:right 
# recursively adding or iteratively adding?
# try using OTHER DATA STRUCTURES?
# IDEA!! - Add into it using the breadth-first search algorithm
# if last entry(in the output list) is null/none pop that out

##### !!!!!!!!!! OUTPUT is just TreeNode NOT A LIST
# then I think it's easy
# just create a tree first and left append both sides equally


