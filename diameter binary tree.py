# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def diameterOfBinaryTree(self, root) -> int:
        val,dia_list=self.diameter_list(root,0,[])
        return max(dia_list)
              

    def diameter_list(self,root,return_val,dia_list=[]):
        if root.left and root.right:
            return_left,dia_list=self.diameter_list(root.left,return_val,dia_list)
            return_right,dia_list=self.diameter_list(root.right,return_val,dia_list)
            dia_list.append(return_left+return_right)
            return_val=max(return_left,return_right)+1

        elif root.left:
            return_val,dia_list=self.diameter_list(root.left,return_val,dia_list)
            dia_list.append(return_val)
            return_val=return_val+1
        elif root.right:
            return_val,dia_list=self.diameter_list(root.right,return_val,dia_list)
            dia_list.append(return_val)
            return_val=return_val+1
        else:
            dia_list.append(return_val)
            return 1,dia_list

        return return_val, dia_list
         

####### I FLUKED MY ABOVE SOLUTION CHECK TOMORROW (Was not fluke, mostly involuntary)


        ## may need to create a seperate function that returns a list with lengths (at nodes where both left and right child are present)
        ## cont... to the main func which then return max(of that list)



    # check notes
    #idea: recursively from each node get the shortest and longest path
    # important nodes are the ones with both left and right (record length for those)
    # if just left or right add 1 while returning
    #



