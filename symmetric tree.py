class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    
    def __init__(self):
        #self.root = TreeNode(root)
        self.inorder_list=[]
        self.reverse_list=[]

    def inorderTraversal(self, start,side):
        if start:
            pass
        else:
            self.inorder_list
        if start.left:
            self.inorder_list=self.inorderTraversal(start.left,side='left')
        if start.val is None:
            pass
        else:
            self.inorder_list.append(start.val)
        if start.right:
            self.inorder_list=self.inorderTraversal(start.right,side='right')
        return self.inorder_list

    def reverseTraversal(self, start,side):
        if start:
            pass
        else:
            self.reverse_list
        if start.right:
            self.reverse_list=self.reverseTraversal(start.right,side='left')
        if start.val is None:
            pass
        else:
            self.reverse_list.append(start.val)
        if start.left:
            self.reverse_list=self.reverseTraversal(start.left,side='right')
        return self.reverse_list


    def isSymmertric(self,root):

        if root.left and root.right:        

            left_side=self.inorderTraversal(root.left,'left')
            right_side=self.reverseTraversal(root.right,'right')
            

        if left_side==right_side:
            return True
        else:
            return False




## THE RIGHT ANSWER
## basically you are comparing nodes level-wise i.e. you are checking if they are mirroring at each level
class Solution:
    
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root, root)
    
    
    def isMirror(self, t1, t2):
        if not t1 and not t2: return True
        if not t1 or not t2: return False
        return t1.val == t2.val and self.isMirror(t1.right, t2.left) and self.isMirror(t1.left, t2.right)




s=Solution()
print(s.isSymmertric())





