class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    
    def __init__(self):
        #self.root = TreeNode(root)
        self.inorder_list=[]

    # def inorderTraversal(self, start):
    #     if start:
    #         pass
    #     else:
    #         self.inorder_list
    #     if start.left:
    #         self.inorder_list=self.inorderTraversal(start.left)
    #     if start.val is None:
    #         pass
    #     else:
    #         self.inorder_list.append(start.val)
    #     if start.right:
    #         self.inorder_list=self.inorderTraversal(start.right)
    #     return self.inorder_list
    

    def inorderTraversal(self, start):
        ## Iterative method (Psuedocode)

        inorder_list = []
        traversal_list = []  ## node objects in here
        visited=[]
        if start:
            traversal_list.append(start)
        else:
            return []
        while traversal_list:
            curr_node = traversal_list[-1]
            if (curr_node.left) and (curr_node.left not in visited):
                traversal_list.append(curr_node.left)
            elif (curr_node.val) and (curr_node not in visited):
                inorder_list.append(curr_node.val)
                visited.append(curr_node)
            elif (curr_node.right) and (curr_node.right not in visited):
                traversal_list.append(curr_node.right)
            else:
                traversal_list.pop()

        return inorder_list



root=TreeNode(1)
root.left=TreeNode(2)
root.right=TreeNode(2)
root.left.left=TreeNode(3)
root.left.right=TreeNode(4)
root.right.right=TreeNode(3)
root.right.left=TreeNode(4)



# root=TreeNode(1)
# root.left=TreeNode(None)  ## if None is added then it will fucking go there, then you should check if curr_node.left.val exists
# root.right=TreeNode(2)
# root.right.left=TreeNode(3)


s=Solution()
print(s.inorderTraversal())


        


        