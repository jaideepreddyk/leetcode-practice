import java.util.ArrayDeque;
import java.util.Queue;


 // The optimal solution for this problem(on leetcode) uses almost the same logic, but in a super efficient and smart way.
 // they made 'max' a global variable within the class (therefore, can be update at any time and don't have to bother with returning and stuff)
// used an integer array to store sum and number of nodes

public class MaxAverageSubtree{
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

    class Tracker{
        int nodes = 0;
        double sum = 0;
        double max = 0;
    }

    public Tracker maximumAverageCalculator(TreeNode root) {
        Tracker tracker = new Tracker();
        Tracker left_tracker;
        Tracker right_tracker;
        tracker.nodes = 1;
        tracker.sum = root.val;
        if(root.left!=null){
            left_tracker = maximumAverageCalculator(root.left); 
        }
        else left_tracker = new Tracker();
        if(root.right!=null){
            right_tracker = maximumAverageCalculator(root.right);
        }
        else right_tracker = new Tracker();
        // total nodes for this subtree
        tracker.nodes = left_tracker.nodes + right_tracker.nodes + 1;
        tracker.sum = left_tracker.sum + right_tracker.sum + root.val;
        tracker.max = tracker.sum/tracker.nodes;
        if(left_tracker.max>tracker.max)tracker.max = left_tracker.max;
        if(right_tracker.max>tracker.max)tracker.max = right_tracker.max;
        return tracker;
    }

    public double maximumAverageSubtree(TreeNode root) {
        Tracker solution = maximumAverageCalculator(root);
        return solution.max;
    }


    public static void main(String[] args) {
        
    }
}

