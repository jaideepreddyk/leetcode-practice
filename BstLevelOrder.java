import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BstLevelOrder {

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

    public List<List<Integer>> leverOrder(TreeNode root){
        Deque<TreeNode> bfsQueue= new ArrayDeque<>();
        List<List<Integer>> output = new ArrayList<>();
        int level_len = 0;

        if(root!=null) {bfsQueue.add(root); level_len++;}

        while(!bfsQueue.isEmpty()){
            List<Integer> level_list = new ArrayList<>();
            int next_level_len = 0;
            for(int i=0; i<level_len;i++){
                TreeNode curr = bfsQueue.removeFirst();
                level_list.add(curr.val);
                if(curr.left!=null){
                    bfsQueue.add(curr.left);
                    next_level_len++;
                }
                if(curr.right!=null){
                    bfsQueue.add(curr.right);
                    next_level_len++;
                }
            }
            output.add(level_list);
            level_len = next_level_len;
        }
        return output;
    } 
}
