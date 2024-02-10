import java.util.ArrayList;
import java.util.List;

class InorderTraversal {
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
    public void inorderHelper(TreeNode root, List<Integer> node_list){
        if(root==null) return;
        inorderHelper(root.left, node_list);
        node_list.add(root.val);
        inorderHelper(root.right, node_list);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderHelper(root, inorder);
        return inorder;
    }
}