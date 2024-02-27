import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetsBacktrackingFaster {
    public void subsetHelper(int[] nums, List<List<Integer>> solution, List<Integer> myList, int index){
        if(index<nums.length){
            myList.addLast(nums[index]);
            subsetHelper(nums, solution, myList, index+1);
            myList.removeLast();
            subsetHelper(nums, solution, myList, index+1);
        }
        else{
            List<Integer> leafList = new ArrayList<>();
            leafList.addAll(myList);
            solution.add(leafList);
            return;
        }
        return;
    }

    public List<List<Integer>> subset(int[] nums){
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> myList = new ArrayList<>();
        if(nums.length>0){
            subsetHelper(nums, solution, myList, 0);
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
        SubsetsBacktrackingFaster answer = new SubsetsBacktrackingFaster();
        System.out.println(answer.subset(input));
    }
}
