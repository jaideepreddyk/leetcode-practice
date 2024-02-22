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

    public void remove(int key){
        TreeNode curr = this.root;
        TreeNode parent = null; // if parent is null, then it means the root is the node to be removed

        while(curr!=null){
            if(key<curr.key){
                parent = curr;
                curr = curr.left;
            }
            else if(key>curr.key){
                parent = curr;
                curr = curr.right;
            }
            else if(key==curr.key){
                break;
            }
        }
        
        if(curr == null) return; // no node found

        // now remove the node
        // at this point curr is the node to be removed
        // to join back, check if parent key is > or < given key
        if(curr.left == null){
            curr = curr.right;
        }
        else if(curr.right == null){
            curr = curr.left;
        }
        else{
            // here I need to do 2 things
            //  1) find the replacement node and update the curr node values with that node's. CAN DO THIS
            //  2) now remove the replacement node from this subtree. While-loop into this and set null when you encounter that maybe

            TreeNode replacement = getMinNode(curr.right);
            curr.key = replacement.key;
            curr.val = replacement.val;

            
        }

    }

}
