import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesOptimal {
    static List<String> backtrackingFunction(int n, List<String> parentheses, int left, int right, String str){
        // length 2*n because we want to return after n opening and n closing brackets. Input n refers to pairs.
        if(str.length()==2*n){
            parentheses.add(str);
            return parentheses;
        }
        if(left<n){
           parentheses = backtrackingFunction(n, parentheses, left+1, right, str+"(");
        }
        if(right<left){
            parentheses = backtrackingFunction(n, parentheses, left, right+1, str+")");
        }
        return parentheses;
    }

    // backtracking solution more - optimal than mine based on run-time complexity
    static List<String> GenerateParentheses(int n){
        // internal method
        List<String> parentheses = new ArrayList<>();
        parentheses = backtrackingFunction(n, parentheses, 0, 0, "");
        return parentheses;
    }


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(GenerateParentheses(n));
    }
}
