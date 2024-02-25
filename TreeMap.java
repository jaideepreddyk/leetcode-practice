import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicTreeUI.TreeIncrementAction;

public class TreeMap {
    public class TreeNode{
        int key;
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int key){
            this.key = key;
        }
        TreeNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    TreeNode root;
    
    public TreeMap(){
        this.root = null;
    }

    public void insert(int key, int val){
        if(this.root==null){
            this.root = new TreeNode(key,val);
        }
        else{
            TreeNode curr = this.root;
            TreeNode parent = null;
            while (curr!=null) {
                parent = curr;
                if(key<curr.key){
                    curr = curr.left;
                }
                else if(key>curr.key){
                    curr = curr.right;
                }
                else{
                    curr.val = val;
                    return;
                }
            }
            if(key<parent.key){
                parent.left = new TreeNode(key, val);
            }
            else if(key>parent.key){
                parent.right = new TreeNode(key,val);
            }
        }
    }

    public int get(int key){
        if(this.root!=null){
            TreeNode curr = this.root;
            while(curr!=null){
                if(key<curr.key){
                    curr = curr.left;
                }
                else if(key>curr.key){
                    curr = curr.right;
                }
                else{
                    return curr.val;
                }
            }
        }
        return -1;
    }

    public int getMin(){
        if(this.root!=null){
            TreeNode curr = this.root;
            while(curr.left!=null){
                curr = curr.left;
            }
            return curr.val;
        }
        return -1;
    }

    public TreeNode getMinNode(TreeNode curr){
        if(curr!=null){
            while(curr.left!=null){
                curr = curr.left;
            }
            return curr;
        }
        return null;
    }

    public int getMax(){
        if(this.root!=null){
            TreeNode curr = this.root;
            while(curr.right!=null){
                curr = curr.right;
            }
            return curr.val;
        }
        return -1;
    }

    public TreeNode getMaxNode(TreeNode curr){
        if(curr!=null){
            while(curr.right!=null){
                curr = curr.right;
            }
            return curr;
        }
        return null;
    }

    public TreeNode removeHelper(TreeNode root, int key){
        if(root==null) return root;
        //find the damn node first
        if(key<root.key){
            root.left = removeHelper(root.left, key);
        }
        else if(key>root.key){
            root.right = removeHelper(root.right, key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                TreeNode min = getMinNode(root.right);
                root.key = min.key;
                root.val = min.val;
                root.right = removeHelper(root.right, min.key);
            }
        }
        return root;
    }

    public void remove(int key){
        this.root = removeHelper(this.root, key);
    }

    public void inorderHelper(TreeNode root, List<Integer> inorder){
        if(root==null){
            return;
        }
        inorderHelper(root.left, inorder);
        inorder.add(root.key);
        inorderHelper(root.right, inorder);
    }

    public List<Integer> getInorderKeys() {
        List<Integer> inorder = new ArrayList<>();
        inorderHelper(this.root, inorder);
        return inorder;
    }

}
