import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {

    public static void helperFunc(int[] candidates, int target, List<List<Integer>> solution, List<Integer> inner_list, int sum, int index){
        while(index<candidates.length){
            sum += candidates[index];
            inner_list.addLast(candidates[index]);
            if(sum==target){
                List<Integer> qualified_list = new ArrayList<>();
                qualified_list.addAll(inner_list);
                solution.add(qualified_list);
            }
            else if(sum<target){
                helperFunc(candidates, target, solution, inner_list, sum, index);
            }
            inner_list.removeLast();
            sum -= candidates[index];
            index++;
        }
        return;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> inner_list = new ArrayList<>();
        helperFunc(candidates, target, solution, inner_list, 0, 0);
        return solution;
    }


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int target = s.nextInt();
        int[] candidates = new int[size];
        for(int i = 0; i<size; i++){
            candidates[i] = s.nextInt();
        }
        System.out.println(combinationSum(candidates, target));
    }
    
}
