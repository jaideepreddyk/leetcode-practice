import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    
    public List<List<Integer>> subsetHelper(int[] input, List<List<Integer>> output, int size){
       //sliding window
       // window size loop
       for(int i=1;i<=size;i++){
            int j = 0;
            while(j+i<=size){
                List<Integer> subset = new ArrayList<>();
                for(int k = 0; k<i; k++){
                    subset.add(input[k+j]);
                }
                j++;
                output.add(subset);
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
