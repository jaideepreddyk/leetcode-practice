import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
     
    // tree class 
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

    // leftside 
    public ArrayList<Integer> leftSide(TreeNode left){
        Queue<TreeNode> traversal = new LinkedList<>();
        ArrayList<Integer> tracker = new ArrayList<>();
        traversal.add(left);
        
        while(traversal.isEmpty()!=true){
            TreeNode curr = traversal.peek();
            if(curr.left!=null) traversal.add(curr.left);
            else if(curr.val!=101) traversal.add(new TreeNode(101));
            if(curr.right!=null) traversal.add(curr.right);
            else if(curr.val!=101) traversal.add(new TreeNode(101));
            tracker.add(curr.val);
            traversal.remove(curr);
        }
        return tracker;
        }
    
    // rightside 
    public ArrayList<Integer> rightSide(TreeNode right){
        Queue<TreeNode> traversal = new LinkedList<>();
        ArrayList<Integer> tracker = new ArrayList<>();
        traversal.add(right);
        
        while(traversal.isEmpty()!=true){
            TreeNode curr = traversal.peek();
            if(curr.right!=null) traversal.add(curr.right);
            else if(curr.val!=101) traversal.add(new TreeNode(101));
            if(curr.left!=null) traversal.add(curr.left);
            else if(curr.val!=101) traversal.add(new TreeNode(101));
            tracker.add(curr.val);
            traversal.remove(curr);
        }
        return tracker;
    }

    public boolean isSymmetric(TreeNode root){
        if(root.left==null && root.right==null) return true;
        else if(root.left==null || root.right==null) return false;
        ArrayList<Integer> leftside = leftSide(root.left);
        ArrayList<Integer> rightside = rightSide(root.right);
        return leftside.equals(rightside);
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] tree_arr = new int[n];
        for(int i =0; i<n; i++){
            tree_arr[i] = s.nextInt();
        }
    }
}
