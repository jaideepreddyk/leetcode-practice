import java.util.Scanner;

public class ConstructBinaryTree {
    public static class TreeNode {
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

    public static int traverseTree(TreeNode root, int[] preorder, int[] inorder, int p, int i){
        if(preorder[p]!=inorder[i]){
            p = p + 1;
            root.left = new TreeNode(preorder[p]);
            i = traverseTree(root.left, preorder, inorder, p, i);
        }
        else if(preorder[p]==inorder[i]){
            return i+1;
        }
        if(root.val == inorder[i]){
            i=i+1;
            if(inorder[i+1]==preorder[p+i+1]){
                i = i + 1;
                root.right = new TreeNode(inorder[i]);
            }
        }
        return i;
    }

    public static TreeNode constructBinaryTree(int[] preorder, int[] inorder){
        // assigning root node
        TreeNode root = new TreeNode(preorder[0]);
        int new_ind =traverseTree(root, preorder, inorder, 0, 0);
        new_ind = traverseTree(root, preorder, inorder, new_ind, new_ind);
        return root;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int[] pre = new int[nodes];
        int[] inorder = new int[nodes];

        // pre order 
        for(int i=0; i<nodes; i++){
            pre[i] = s.nextInt();
        }
        // inorder
        for(int i=0; i<nodes; i++){
            inorder[i] = s.nextInt();
        }
    }
}
