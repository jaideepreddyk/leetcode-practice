
public class SymmetricTreeOptimal{
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    public boolean isSymmetric(TreeNode root){
        if(root.left == null && root.right== null) return true;
        else if(root.left == null || root.right == null) return false;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left!=null && right!=null){
            if(left.val == right.val) return true && isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        else if(left==null && right==null) return true;
        return false;
    }
    public static void main(String[] args){

    }
}
