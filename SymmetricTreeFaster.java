import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTreeFaster {
     
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

    public boolean isSymmetric(TreeNode root){
        if(root.left==null && root.right==null) return true;
        else if(root.left==null || root.right==null) return false;
        if(root.left.val != root.right.val) return false;

        Queue<TreeNode> left_curr = new LinkedList<>();
        Queue<TreeNode> right_curr = new LinkedList<>();
        Queue<TreeNode> left_new= new LinkedList<>();
        Queue<TreeNode> right_new = new LinkedList<>();
        
        // add current left and right 
        left_curr.add(root.left);
        right_curr.add(root.right);


        while(left_curr.isEmpty()!=true && right_curr.isEmpty()!=true){
            ArrayList<Integer> left_tracker = new ArrayList<>();
            ArrayList<Integer> right_tracker = new ArrayList<>();

            for(int i = 0; i<left_curr.size(); i++){
                // left side
                TreeNode curr = left_curr.remove();
                if(curr.left!=null) {left_new.add(curr.left); left_tracker.add(curr.left.val);}
                else left_tracker.add(101);
                if(curr.right!=null) {left_new.add(curr.right); left_tracker.add(curr.right.val);}
                else left_tracker.add(101);

                // right side
                curr = right_curr.remove();
                if(curr.right!=null) {right_new.add(curr.right); right_tracker.add(curr.right.val);}
                else right_tracker.add(101);
                if(curr.left!=null) {right_new.add(curr.left); right_tracker.add(curr.left.val);}
                else right_tracker.add(101);
            }
            left_curr = left_new;
            right_curr = right_new;

            if(left_tracker.equals(right_tracker)==false){
                return false;
            }

        }
        return true;
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
