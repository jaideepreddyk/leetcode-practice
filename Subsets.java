import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    
    public List<List<Integer>> subsetHelper(int[] input, List<List<Integer>> output, int size){
       for(int i = 0; i<size; i++){
            // adding each singleton element here
            List<Integer> curr = new ArrayList<>();
            curr.add(input[i]);
            output.add(curr);
            // window size intitalize
            int window = 1;
            while(window<size-i && i+1<size){
                for(int j=i+1; j<size; j++){
                    if(j+window<=size){
                        curr = new ArrayList<>();
                        curr.add(input[i]);
                        for(int k=0;k<window;k++){
                            curr.add(input[j+k]);
                        }
                        output.add(curr);
                    }
                }
                window++;
            }
       }
       return output;
    }

    public List<List<Integer>> subSets(int[] input){
        List<List<Integer>> output = new ArrayList<>();
        int size = input.length;
        // adding empty list here only
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
