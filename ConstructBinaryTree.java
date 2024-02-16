import java.util.Arrays;
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

    public static TreeNode traverseTree(int[] preorder, int[] inorder){
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length>1){
            int mid = 0;
            while(inorder[mid]!=preorder[0]){
                mid++;
            }
            if(mid>0){
                root.left = traverseTree(Arrays.copyOfRange(preorder, 1, 1+mid), Arrays.copyOfRange(inorder, 0, mid));
            }
            if(mid<preorder.length-1){
            root.right = traverseTree(Arrays.copyOfRange(preorder, mid+1, preorder.length), Arrays.copyOfRange(inorder, mid+1, inorder.length));
            }
        }
        return root;
    }

    public static TreeNode constructBinaryTree(int[] preorder, int[] inorder){
        TreeNode root = traverseTree(preorder, inorder);
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
