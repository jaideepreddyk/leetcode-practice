import javax.xml.parsers.FactoryConfigurationError;

public class PathSum {
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

    public boolean pathSumHelper(TreeNode root, int targetSum, int currSum){
        currSum += root.val;
        if(currSum==targetSum & root.left==null & root.right==null){
            return true;
        }
        
        if(root.left!=null && pathSumHelper(root.left, targetSum, currSum)){
            return true;
        }
        if(root.right!=null && pathSumHelper(root.right, targetSum, currSum)){
            return true;
        }
        currSum -= root.val;
        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root!=null) return pathSumHelper(root, targetSum, 0);
        else return false;
    }
}
