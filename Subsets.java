import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    
    public List<List<Integer>> subsetHelper(int[] input, List<List<Integer>> output, int size){
        for(int i=0; i<size;i++){
            for(int j=i; j<size; j++){
                List<Integer> curr = new ArrayList<>();
                if(i==j){
                    curr.add(input[i]);
                }
                else{
                    for(int k=i; k<=j; k++){
                        curr.add(input[k]);
                    }
                }
                output.add(curr);
            }
        }
        return output;
    }

    public List<List<Integer>> subSets(int[] input){
        List<List<Integer>> output = new ArrayList<>();
        int size = input.length;
        output.add(new ArrayList<Integer>());
        output = subsetHelper(input, output, size);
        return output;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] input = new int[size];
        // input array read
        for(int i =0; i<size; i++){
            input[i] = s.nextInt();
        }
        Subsets answer = new Subsets();
        System.out.println(answer.subSets(input));
    }
}
