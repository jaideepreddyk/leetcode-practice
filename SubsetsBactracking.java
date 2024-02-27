import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetsBactracking {
    public class TreeNode{
        List<Integer> subset;
        TreeNode left;
        TreeNode right;
        TreeNode(){
            this.subset = new ArrayList<>();
        }
        public void add(int num){
            this.subset.add(num);
        }
    }

    public void subsetHelper(int[] nums, List<List<Integer>> solution, TreeNode root, int index){
        // add left node and then add the current value 
        root.left = new TreeNode();
        root.left.subset.addAll(root.subset);
        root.left.add(nums[index]);
        // add right
        root.right = new TreeNode();
        root.right.subset.addAll(root.subset);
        
        if(index<nums.length-1){
            subsetHelper(nums, solution, root.left, index+1);
            subsetHelper(nums, solution, root.right, index+1);
        }
        else{
            solution.add(root.left.subset);
            solution.add(root.right.subset);
            return;
        }
        return;
    }

    public List<List<Integer>> subset(int[] nums){
        List<List<Integer>> solution = new ArrayList<>();
        TreeNode root = new TreeNode();
        if(nums.length>0){
            subsetHelper(nums, solution, root, 0);
        }
        return solution;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] input = new int[size];
        // input array read
        for(int i =0; i<size; i++){
            input[i] = s.nextInt();
        }
        SubsetsBactracking answer = new SubsetsBactracking();
        System.out.println(answer.subset(input));
    }
}
