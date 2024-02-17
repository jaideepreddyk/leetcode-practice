import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeRightSideView{
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

    public List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> bfs_output = new ArrayList<>();
        Deque<TreeNode> trackingDeque = new ArrayDeque<>();
        int level_len = 0;

        if(root!=null){
            trackingDeque.add(root);
            level_len++;
        }

        while(!trackingDeque.isEmpty()){
            List<Integer> level_list = new ArrayList<>();
            int next_level_len = 0;
            for(int i =0; i<level_len;i++){
                TreeNode curr = trackingDeque.removeFirst();
                level_list.add(curr.val);
                if(curr.left!=null){
                    trackingDeque.add(curr.left);
                    next_level_len++;
                }
                if(curr.right!=null){
                    trackingDeque.add(curr.right);
                    next_level_len++;
                }
            }
            level_len = next_level_len;
            bfs_output.add(level_list);
        }
        return bfs_output;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> bfs_traversal = bfs(root);
        List<Integer> rightside = new ArrayList<>();
        for(List<Integer> levels : bfs_traversal){
            rightside.add(levels.getLast());
        }
        return rightside;
    }
}
